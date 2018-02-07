import sys


def is_non_terminal(character):
    return 'A' <= character <= 'Z'


def is_terminal(character):
    return '1' <= character <= '9' or 'a' <= character <= 'z' or character in ['*', '-', '+', '(', ')']


first_set = {}


def main():
    global first_set
    # grammar_file = open('grammer.txt', 'r')
    grammar_file = sys.stdin
    grammar_lines = int(grammar_file.readline())

    rules = []
    for _ in range(0, grammar_lines):
        grammar_rule = grammar_file.readline()
        if grammar_rule[-1] == '\n':
            grammar_rule = grammar_rule[:-1]

        rules.append(grammar_rule.split(' '))

    # grammar_file.close()

    for i in range(0, grammar_lines):
        if not rules[i][0] in first_set:  # checking if first table for this variable exists and adding it if not
            first_set[rules[i][0]] = []

    iteration_had_changes = True

    while iteration_had_changes:
        iteration_had_changes = False
        for i in range(0, grammar_lines):
            first_changed = add_to_first(rules[i])
            if first_changed:
                iteration_had_changes = True

    for key in first_set:
        result = ''
        first_set[key].sort()
        for item in first_set[key]:
            result += item + ' '
        result = result[:-1]
        print(result)

    grammar_file.read()


def add_to_first(rule):
    global first_set
    made_changes = False

    if not rule[0] in first_set:  # checking if first table for this variable exists and adding it if not
        first_set[rule[0]] = []
        made_changes = True

    for i in range(2, len(rule)):
        if is_terminal(rule[i]) or rule[i] == '#':
            if not rule[i] in first_set[rule[0]]:
                first_set[rule[0]].append(rule[i])
                made_changes = True

            break
        elif is_non_terminal(rule[i]):

            if not rule[i] in first_set:  # checking if first table for this variable exists and adding it if not
                first_set[rule[i]] = []
                made_changes = True

            for first_set_member in first_set[rule[i]]:
                if first_set_member not in first_set[rule[0]]:
                    if not first_set_member == '#':
                        first_set[rule[0]].append(first_set_member)
                        made_changes = True
                    elif i == len(rule) - 1:
                        first_set[rule[0]].append(first_set_member)
                        made_changes = True

            if '#' not in first_set[rule[i]]:
                break

    return made_changes


if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        exit(0)
