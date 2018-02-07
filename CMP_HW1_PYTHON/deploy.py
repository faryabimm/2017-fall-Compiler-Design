# -----> reading source file 1

language_file = open('language.py', 'r')
language_code = language_file.read()
language_file.close()

# -----> reading source file 2

lexical_analyzer_file = open('lexical_analyzer.py', 'r')
lexical_analyzer_code = lexical_analyzer_file.read()
lexical_analyzer_file.close()

# -----> removing name references to source file 2 from source file 1

lexical_analyzer_code = lexical_analyzer_code.replace('language.', '')
lexical_analyzer_code = lexical_analyzer_code.replace('import language', '')

# -----> removing import sys. will be added later so that all imports will be together

lexical_analyzer_code = lexical_analyzer_code.replace('import sys', '')

# -----> changing code behavior to obtain input from stdin rather than a file

lexical_analyzer_code = lexical_analyzer_code.replace('# program = sys.stdin.read()', 'program = sys.stdin.read()')
lexical_analyzer_code = lexical_analyzer_code.replace('program_file = open(\'program_3.txt\', \'r\')',
                                                      '# program_file = open(\'program_3.txt\', \'r\')')
lexical_analyzer_code = lexical_analyzer_code.replace('program_file = open(\'program_2.txt\', \'r\')',
                                                      '# program_file = open(\'program_2.txt\', \'r\')')
lexical_analyzer_code = lexical_analyzer_code.replace('program_file = open(\'program_1.txt\', \'r\')',
                                                      '# program_file = open(\'program_1.txt\', \'r\')')
lexical_analyzer_code = lexical_analyzer_code.replace('program = program_file.read()',
                                                      '# program = program_file.read()')
lexical_analyzer_code = lexical_analyzer_code.replace('program_file.close()', '# program_file.close()')

# -----> creating merged source code and saving it in a source file named cmp_hw1.py

source_code = 'import sys\n' + language_code + lexical_analyzer_code
source_file = open('cmp_hw1.py', 'w')
source_file.write(source_code)
source_file.close()
