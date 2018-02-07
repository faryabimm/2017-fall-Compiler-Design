import sys
import re

keywords = ['auto', 'bool', 'break', 'case', 'char', 'class', 'const', 'continue', 'default', 'destruct', 'double',
            'else', 'false', 'float', 'for', 'foreach', 'goto', 'if', 'in', 'inherit', 'int', 'long', 'new', 'private',
            'procedure', 'public', 'repeat', 'return', 'sizeof', 'static', 'string', 'switch', 'true', 'until', 'void']
operator_values = ['not', 'not equal', 'mod', 'arithmetic and', 'logical and', 'opening parenthesis',
                   'closing parenthesis', 'production', 'add', 'increment', 'comma', 'sub and unary minus',
                   'decrement', 'dot', 'div', 'colon', 'semi_colon', 'less than', 'less or equal', 'assignment',
                   'equal', 'bigger than', 'bigger or equal', 'opening brace', 'closing brace',
                   'logical/arithmetic xor', 'opening curly brace', 'arithmetic or', 'logical or',
                   'closing curly brace']
operator_keys = ['!', '!=', '%', '&', '&&', '(', ')', '*', '+', '++', ',', '-', '--', '.', '/', ':', ';', '<',
                 '<=', '=', '==', '>', '>=', '[', ']', '^', '{', '|', '||', '}']

identifier_pattern = re.compile('[a-zA-Z](_{0,2}[a-zA-Z0-9])*|_{1,2}[a-zA-Z0-9](_{0,2}[a-zA-Z0-9])*')
integer_pattern = re.compile('-?\d+')
hex_pattern = re.compile('-?0x[0-9a-fA-F]+')
dummy_hex_pattern = re.compile('-?0x[0-9a-fA-F]*')
real_pattern = re.compile('-?\d*\.\d*')
scientific_real_pattern = re.compile('-?\d+[eE][+\-]?\d+')
dummy_sci_real_pattern = re.compile('-?\d+[eE][+\-]?\d*')
r_comment_pattern = re.compile('@@(.*)')
m_comment_pattern = re.compile('/@([\S\s]*)@/')
string_pattern = re.compile('"((?:[^"\\\]|\\\.)*)"')
char_pattern = re.compile("'(\\\\'|\\\\t|\\\\n|\\\\\\\\|[^'\\\\])'")


check_word = ''
match_type = -1
is_operator_key = 0


def is_keyword(a=0, b=35):
    c = (a + b) // 2
    if keywords[c] == check_word:
        return True
    elif b - a <= 1:
        return False

    if keywords[c] < check_word:
        return is_keyword(c, b)
    else:
        return is_keyword(a, c)


def is_operator(a=0, b=30):
    c = (a + b) // 2
    if operator_keys[c] == check_word:
        return True, c
    elif b - a <= 1:
        return False, c

    if operator_keys[c] < check_word:
        return is_operator(c, b)
    else:
        return is_operator(a, c)


class LexicalAnalyzer:
    def __init__(self, program):
        self.line_number = 1
        self.program = program
        self.program_size = len(self.program)
        self.first_head = 0
        self.second_head = 0
        self.scan_error = False

    def print_cond(self, string):
        if not self.scan_error:
            print(string)

    def has_next(self):
        return self.first_head < self.program_size

    def scan_next(self):
        self.skip_whitespaces()
        self.second_head = self.first_head

        while not self.has_match():
            self.second_head += 1
            if self.second_head == self.program_size:
                self.second_head = self.program_size
                break
        while self.has_match() or self.m_comment_pending() or self.mu_id_pending():
            self.second_head += 1
            if self.second_head == self.program_size:
                self.second_head = self.program_size
                break
        self.second_head -= 1

        self.extract_token()
        self.first_head = self.second_head + 1
        self.second_head += 1

    def has_match(self):
        chunk = self.program[self.first_head:self.second_head + 1]
        global check_word, match_type, is_operator_key
        check_word = chunk

        if is_keyword():
            match_type = 0
            return True
        if not identifier_pattern.fullmatch(chunk) is None:
            match_type = 1
            return True
        if not integer_pattern.fullmatch(chunk) is None:
            match_type = 2
            return True
        if not hex_pattern.fullmatch(chunk) is None:
            match_type = 3
            return True
        if not real_pattern.fullmatch(chunk) is None:
            match_type = 4
            return True
        if not scientific_real_pattern.fullmatch(chunk) is None:
            match_type = 5
            return True
        if not r_comment_pattern.fullmatch(chunk) is None:
            match_type = 7
            return True
        if not m_comment_pattern.fullmatch(chunk) is None:
            match_type = 8
            return True
        if not string_pattern.fullmatch(chunk) is None:
            match_type = 9
            return True
        if not char_pattern.fullmatch(chunk) is None:
            match_type = 10
            return True
        if not dummy_sci_real_pattern.fullmatch(chunk) is None:
            match_type = 11
            return True
        if not dummy_hex_pattern.fullmatch(chunk) is None:
            match_type = 12
            return True
        is_op_res, is_operator_key = is_operator()
        if is_op_res:
            match_type = 6
            return True
        return False

    def m_comment_pending(self):
        chunk = self.program[self.first_head:self.second_head + 1]
        return chunk.startswith('/@') and not chunk[:-1].endswith('@/')

    # helps maintain id capturing process when there is mid underline in id
    def mu_id_pending(self):
        chunk = self.program[self.first_head:self.second_head + 1]
        chunk_striped = chunk.rstrip('_')
        return not identifier_pattern.fullmatch(chunk_striped) is None

    def extract_token(self):
        lexeme = self.program[self.first_head:self.second_head + 1]
        global check_word, is_operator_key
        check_word = lexeme

        if match_type == 0:
            self.print_cond('line {}: keyword "{}"'.format(self.line_number, lexeme))

        elif match_type == 1:
            self.print_cond('line {}: id "{}"'.format(self.line_number, lexeme))

        elif match_type == 6:
            operator = operator_values[is_operator_key]
            self.print_cond('line {}: operator "{}"'.format(self.line_number, operator))

        elif match_type == 2:
            self.print_cond('line {}: integer'.format(self.line_number))

        elif match_type == 3:
            self.print_cond('line {}: integer'.format(self.line_number))

        elif match_type == 4:
            self.print_cond('line {}: real'.format(self.line_number))

        elif match_type == 5:
            self.print_cond('line {}: real'.format(self.line_number))

        elif match_type == 7:
            comment = r_comment_pattern.fullmatch(lexeme).group(1)
            self.print_cond('line {}: comment "{}"'.format(self.line_number, comment))

        elif match_type == 8:
            comment = m_comment_pattern.fullmatch(lexeme).group(1)
            comment_lines = len(comment.split('\n')) - 1
            self.print_cond(
                'line {}-{}: comment "{}"'.format(self.line_number, self.line_number + comment_lines, comment))
            self.line_number += comment_lines

        elif match_type == 9:
            self.print_cond('line {}: string'.format(self.line_number))

        elif match_type == 10:
            self.print_cond('line {}: char'.format(self.line_number))

        elif match_type == 11:
            if lexeme.endswith('+') or lexeme.endswith('-'):
                self.second_head -= 2
                self.extract_token()
            elif lexeme.endswith('e') or lexeme.endswith('E'):
                self.second_head -= 1
                self.extract_token()
        elif match_type == 12:
            if lexeme.endswith('x') or lexeme.endswith('X'):
                self.second_head -= 1
                self.extract_token()

        elif not identifier_pattern.fullmatch(lexeme.rstrip('_')) is None:
            self.print_cond('line {}: id "{}"'.format(self.line_number, lexeme.rstrip('_')))
            self.scan_error = True
        else:
            self.scan_error = True

    # efficient
    def skip_whitespaces(self):
        while self.program[self.first_head] in [' ', '\t', '\n']:
            if self.program[self.first_head] == '\n':
                self.line_number += 1
            if self.first_head >= self.program_size - 1:
                break
            self.first_head += 1


# efficient
def main():
    # program_file = open('program_3.txt', 'r')
    # program = program_file.read()
    # program_file.close()

    program = sys.stdin.read()

    lexical_analyzer = LexicalAnalyzer(program)
    while lexical_analyzer.has_next():
        lexical_analyzer.scan_next()


# efficient
if __name__ == '__main__':  # efficient
    try:
        main()
    except KeyboardInterrupt:
        exit(0)
