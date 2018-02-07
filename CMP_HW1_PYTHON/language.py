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
