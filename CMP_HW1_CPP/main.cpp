#include <iostream>

using namespace std;

enum scanner_state {
    none,
    id_kw,
    id_1d,
    id_2d,
    integer_float_l_float_r_float_b_hex_minus,
    integer_float_l_float_b_sci,
    integer_float_l_float_b_sci_hex,
    float_l_float_b_dot,
    float_r_dot,
    float_b,
    float_r,
    error,
    div_mcomm,
    d_op_eq,
    d_op_same,
    hex_x,
    hexadecimal,
    sci_e,
    sci_e_minus_plus,
    sci,
    mcomm,
    mcomm_term,
    id,
    scomm_init,
    scomm,
    sstring,
    sstring_scaped,
    ccharacter,
};

string get_single_op_name(char op) {
    switch (op) {
        case '%':
            return "mod";
        case '(':
            return "opening parenthesis";
        case ')':
            return "closing parenthesis";
        case '*':
            return "production";
        case ',':
            return "comma";
        case ':':
            return "colon";
        case ';':
            return "semi_colon";
        case '[':
            return "opening brace";
        case ']':
            return "closing brace";
        case '^':
            return "logical/arithmetic xor";
        case '{':
            return "opening curly brace";
        case '}':
            return "closing curly brace";
        case '!':
            return "not";
        case '&':
            return "arithmetic and";
        case '+':
            return "add";
        case '<':
            return "less than";
        case '=':
            return "assignment";
        case '>':
            return "bigger than";
        case '|':
            return "arithmetic or";
        default:
            return "";
    }
}

string get_double_op_name_eq(char op) {
    switch (op) {
        case '!':
            return "not equal";
        case '<':
            return "less or equal";
        case '>':
            return "bigger or equal";
        case '=':
            return "equal";
        default:
            return "";
    }
}

string get_double_op_name_same(char op) {
    switch (op) {
        case '&':
            return "logical and";
        case '+':
            return "increment";
        case '|':
            return "logical or";
        default:
            return "";
    }
}

bool is_keyword(int a, int b, const string &check_word) {
    static string keywords[35] = {"auto", "bool", "break", "case", "char", "class", "const", "continue", "default",
                                  "destruct",
                                  "double", "else", "false", "float", "for", "foreach", "goto", "if", "in", "inherit",
                                  "int",
                                  "long", "new", "private", "procedure", "public", "repeat", "return", "sizeof",
                                  "static",
                                  "string", "switch", "true", "until", "void"};
    int c = (a + b) / 2;
    if (keywords[c] == check_word) {
        return true;
    } else if (b - a <= 1) {
        return false;
    }

    if (keywords[c] < check_word) {
        return is_keyword(c, b, check_word);
    } else {
        return is_keyword(a, c, check_word);
    }

}

bool line_increment = false;

char get_next_char(long *line_number) {

    char c;
    if (line_increment) {
        line_increment = false;
        (*line_number)++;
    }
    scanf("%c", &c);
    if (c == '\n') line_increment = true;
    return c;
}

bool is_letter(char c) {
    return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
}

bool is_digit(char c) {
    return (c >= '0' && c <= '9');
}

bool is_hex_digit(char c) {
    return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
}

bool is_single_operator(char c) {
    return (c == '%') || (c == '(') || (c == ')') || (c == '*') || (c == ',') || (c == ':') || (c == ';')
           || (c == '[') || (c == ']') || (c == '^') || (c == '{') || (c == '}');

//    '&', '&&', '+', '++', '-', '--', '|', '||',
}

bool is_double_op_tail_eq(char c) {
    return (c == '!') || (c == '<') || (c == '=') || (c == '>');
}

bool is_double_op_tail_same(char c) {
    return (c == '&') || (c == '+') || (c == '|');
}

int main() {
//    stdin = stdin;
//    stdin = fopen("/Users/mohammadmahdi/Development/CLionProjects/CMP_HW1/program.txt", "r");
    string lexeme;
    lexeme.clear();
    scanner_state state;
    state = none;
    long line_number;
    line_number = 1;
    long mcomm_start_line;
    mcomm_start_line = 1;

    char next_char;
    next_char = '\0';
    bool dont_scan;
    dont_scan = false;

    while (true) {
        if (dont_scan) {
            dont_scan = false;
        } else {
            next_char = get_next_char(&line_number);
        }

        if (state == error) {
            break;
        }
        switch (state) {
            case none:
                if (feof(stdin) || next_char == '\0') {
                    state = error;
                }
                if (next_char == ' ' || next_char == '\t' || next_char == '\n') {
                    continue;
                }
                if (is_letter(next_char)) {
                    lexeme += next_char;
                    state = id_kw;
                } else if (next_char == '_') {
                    lexeme += next_char;
                    state = id_1d;
                } else if (next_char == '-') {
                    lexeme += next_char;
                    state = integer_float_l_float_r_float_b_hex_minus;
                } else if (next_char == '/') {
                    lexeme += next_char;
                    state = div_mcomm;
                } else if (next_char == '0') {
                    lexeme += next_char;
                    state = integer_float_l_float_b_sci_hex;
                } else if (is_digit(next_char)) {
                    lexeme += next_char;
                    state = integer_float_l_float_b_sci;
                } else if (is_single_operator(next_char)) {
                    state = none;
                    cout << "line " << line_number << ": operator \"" << get_single_op_name(next_char) << "\"" << endl;
                    lexeme.clear();
                } else if (is_double_op_tail_eq(next_char)) {
                    lexeme += next_char;
                    state = d_op_eq;
                } else if (is_double_op_tail_same(next_char)) {
                    lexeme += next_char;
                    state = d_op_same;
                } else if (next_char == '@') {
                    state = scomm_init;
                } else if (next_char == '\'') {
                    state = ccharacter;
                } else if (next_char == '"') {
                    state = sstring;
                } else if (next_char == '.') {
                    lexeme += next_char;
                    state = float_r_dot;
                } else {
                    state = error;
                }
                break;
            case id_kw:
                if (is_digit(next_char) || is_letter(next_char)) {
                    lexeme += next_char;
                } else if (next_char == '_') {
                    lexeme += next_char;
                    state = id_1d;
                } else {
                    string type = is_keyword(0, 35, lexeme) ? "keyword" : "id";
                    dont_scan = true;
                    cout << "line " << line_number << ": " << type << " \"" << lexeme << "\"" << endl;
                    lexeme.clear();
                    state = none;
                }
                break;
            case integer_float_l_float_b_sci:
                if (is_digit(next_char)) {
                    lexeme += next_char;
                } else if (next_char == 'e' || next_char == 'E') {
                    lexeme += next_char;
                    state = sci_e;
                } else if (next_char == '.') {
                    lexeme += next_char;
                    state = float_l_float_b_dot;
                } else {
                    cout << "line " << line_number << ": integer" << endl;
//                    cout << "line " << line_number << ": integer \"" << lexeme << "\"" << endl;
                    state = none;
                    dont_scan = true;
                    lexeme.clear();
                }
                break;
            case integer_float_l_float_r_float_b_hex_minus:
                if (next_char == '.') {
                    lexeme += next_char;
                    state = float_r_dot;
                } else if (next_char == '0') {
                    lexeme += next_char;
                    state = integer_float_l_float_b_sci_hex;
                } else if (is_digit(next_char)) {
                    lexeme += next_char;
                    state = integer_float_l_float_b_sci;
                } else if (next_char == '-') {
                    state = none;
                    cout << "line " << line_number << ": operator \"decrement\"" << endl;
                    lexeme.clear();
                } else {
                    state = none;
                    dont_scan = true;
                    cout << "line " << line_number << ": operator \"sub and unary minus\"" << endl;
                    lexeme.clear();
                }
                break;
            case float_l_float_b_dot:
                if (is_digit(next_char)) {
                    lexeme += next_char;
                    state = float_b;
                } else {
                    cout << "line " << line_number << ": real" << endl;
//                    cout << "line " << line_number << ": real \"" << lexeme << "\"" << endl;
                    dont_scan = true;
                    state = none;
                    lexeme.clear();
                }
                break;
            case float_r_dot:
                if (is_digit(next_char)) {
                    lexeme += next_char;
                    state = float_r;
                } else {
                    if (lexeme.size() == 2) {
                        cout << "line " << line_number << ": operator \"sub and unary minus\"" << endl;
                    }
                    cout << "line " << line_number << ": operator \"dot\"" << endl;
                    lexeme.clear();
                    dont_scan = true;
                    state = none;
                }
                break;
            case float_b:
                if (is_digit(next_char)) {
                    lexeme += next_char;
                } else {
                    cout << "line " << line_number << ": real" << endl;
//                    cout << "line " << line_number << ": real \"" << lexeme << "\"" << endl;
                    lexeme.clear();
                    dont_scan = true;
                    state = none;
                }
                break;
            case float_r:
                if (is_digit(next_char)) {
                    lexeme += next_char;
                } else {
                    cout << "line " << line_number << ": real" << endl;
//                    cout << "line " << line_number << ": real \"" << lexeme << "\"" << endl;
                    lexeme.clear();
                    dont_scan = true;
                    state = none;
                }
                break;
            case div_mcomm:
                if (next_char == '@') {
                    mcomm_start_line = line_number;
                    lexeme.clear();
                    state = mcomm;
                } else {
                    cout << "line " << line_number << ": operator \"div\"" << endl;
                    lexeme.clear();
                    dont_scan = true;
                    state = none;
                }
                break;
            case d_op_eq:
                if (next_char == '=') {
                    char chr;
                    chr = '\0';
                    chr = lexeme.back();
                    cout << "line " << line_number << ": operator \"" << get_double_op_name_eq(chr) << "\"" << endl;
                    lexeme.clear();
                    state = none;
                } else {
                    char chr;
                    chr = '\0';
                    chr = lexeme.back();
                    cout << "line " << line_number << ": operator \"" << get_single_op_name(chr) << "\"" << endl;
                    lexeme.clear();
                    dont_scan = true;
                    state = none;
                }
                break;
            case d_op_same:
                if (next_char == lexeme.back()) {
                    char chr;
                    chr = '\0';
                    chr = lexeme.back();
                    cout << "line " << line_number << ": operator \"" << get_double_op_name_same(chr) << "\"" << endl;
                    lexeme.clear();
                    state = none;
                } else {
                    char chr;
                    chr = '\0';
                    chr = lexeme.back();
                    cout << "line " << line_number << ": operator \"" << get_single_op_name(chr) << "\"" << endl;
                    lexeme.clear();
                    dont_scan = true;
                    state = none;
                }
                break;
            case id_1d:
                if (is_digit(next_char) || is_letter(next_char)) {
                    lexeme += next_char;
                    state = id;
                } else if (next_char == '_') {
                    lexeme += next_char;
                    state = id_2d;
                } else {
                    lexeme.pop_back();
                    if (!lexeme.empty()) {
                        cout << "line " << line_number << ": id \"" << lexeme << "\"" << endl;
                    }
                    state = error;
                }
                break;
            case id:
                if (is_digit(next_char) || is_letter(next_char)) {
                    lexeme += next_char;
                    state = id;
                } else if (next_char == '_') {
                    lexeme += next_char;
                    state = id_1d;
                } else {
                    cout << "line " << line_number << ": id \"" << lexeme << "\"" << endl;
                    state = none;
                    dont_scan = true;
                    lexeme.clear();
                }
                break;
            case id_2d:
                if (is_digit(next_char) || is_letter(next_char)) {
                    lexeme += next_char;
                    state = id;
                } else {
                    lexeme.pop_back();
                    lexeme.pop_back();
                    if (!lexeme.empty()) {
                        cout << "line " << line_number << ": id \"" << lexeme << "\"" << endl;
                    }
                    state = error;
                }
                break;
            case integer_float_l_float_b_sci_hex:
                if (next_char == 'x') {
                    lexeme += next_char;
                    state = hex_x;
                } else if (next_char == '.') {
                    lexeme += next_char;
                    state = float_l_float_b_dot;
                } else if (next_char == 'e' || next_char == 'E') {
                    lexeme += next_char;
                    state = sci_e;
                } else if (is_digit(next_char)) {
                    lexeme += next_char;
                    state = integer_float_l_float_b_sci;
                } else {
//                    cout << "line " << line_number << ": integer \"" << lexeme << "\"" << endl;
                    cout << "line " << line_number << ": integer" << endl;
                    dont_scan = true;
                    lexeme.clear();
                    state = none;
                }
                break;
            case hex_x:
                if (is_hex_digit(next_char)) {
                    lexeme += next_char;
                    state = hexadecimal;
                } else {
                    char temp_x;
                    temp_x = '\0';
                    temp_x = lexeme.back();
                    lexeme.pop_back();
//                    cout << "line " << line_number << ": integer \"" << lexeme << "\"" << endl;
                    cout << "line " << line_number << ": integer" << endl;
                    dont_scan = true;
                    lexeme.clear();
                    lexeme += temp_x;
                    state = id_kw;
                }

                break;
            case sci_e:
                if (is_digit(next_char)) {
                    lexeme += next_char;
                    state = sci;
                } else if (next_char == '-' || next_char == '+') {
                    lexeme += next_char;
                    state = sci_e_minus_plus;
                } else {
                    char exp;
                    exp = '\0';
                    exp = lexeme.back();
                    lexeme.pop_back();
                    cout << "line " << line_number << ": integer" << endl;
//                    cout << "line " << line_number << ": integer \"" << lexeme << "\"" << endl;
                    dont_scan = true;
                    lexeme.clear();
                    lexeme += exp;
                    state = id_kw;
                }
                break;
            case hexadecimal:
                if (is_hex_digit(next_char)) {
                    lexeme += next_char;
                } else {
                    cout << "line " << line_number << ": integer" << endl;
//                    cout << "line " << line_number << ": integer \"" << lexeme << "\"" << endl;
                    state = none;
                    dont_scan = true;
                    lexeme.clear();
                }
                break;
            case sci_e_minus_plus:
                if (is_digit(next_char)) {
                    lexeme += next_char;
                    state = sci;
                } else {
                    char op;
                    op = '\0';
                    char exp;
                    exp = '\0';
                    op = lexeme.back();
                    lexeme.pop_back();
                    exp = lexeme.back();
                    lexeme.pop_back();
                    cout << "line " << line_number << ": integer" << endl;
//                    cout << "line " << line_number << ": integer \"" << lexeme << "\"" << endl;
                    cout << "line " << line_number << ": id \"" << exp << "\"" << endl;
                    lexeme.clear();
                    lexeme += op;
                    dont_scan = true;
                    state = integer_float_l_float_r_float_b_hex_minus;
                }

                break;
            case sci:
                if (is_digit(next_char)) {
                    lexeme += next_char;
                } else {
                    cout << "line " << line_number << ": real" << endl;
//                    cout << "line " << line_number << ": real \"" << lexeme << "\"" << endl;
                    dont_scan = true;
                    state = none;
                    lexeme.clear();
                }
                break;
            case mcomm:
                if (feof(stdin) || next_char == '\0') {
                    cout << "line " << line_number << ": operator \"div\"" << endl;
                    state = error;
                } else if (next_char == '@') {
                    lexeme += next_char;
                    state = mcomm_term;
                } else {
                    lexeme += next_char;
                }
                break;
            case mcomm_term:
                if (next_char == '/') {
                    lexeme.pop_back();
                    cout << "line " << mcomm_start_line << "-" << line_number << ": comment \"" << lexeme << "\""
                         << endl;
                    state = none;
                    lexeme.clear();
                } else if (next_char == '@') {
                    lexeme += next_char;
                } else if (feof(stdin) || next_char == '\0') {
                    cout << "line " << line_number << ": operator \"div\"" << endl;
                    state = error;
                } else {
                    lexeme += next_char;
                    state = mcomm;
                }
                break;
            case scomm_init:
                if (next_char == '@') {
                    state = scomm;
                } else {
                    state = error;
                }
                break;
            case scomm:
                if (next_char == '\n' || feof(stdin) || next_char == '\0') {
                    cout << "line " << line_number << ": comment \"" << lexeme << "\"" << endl;
                    lexeme.clear();
                    state = none;
                } else {
                    lexeme += next_char;
                }
                break;
            case sstring:
                if (feof(stdin) || next_char == '\0') {
                    state = error;
                } else if (next_char == '\n') {
                    state = error;
                    lexeme.clear();
                } else if (next_char == '"') {
                    cout << "line " << line_number << ": string" << endl;
//                    cout << "line " << line_number << ": string \"" << lexeme << "\"" << endl;
                    state = none;
                    lexeme.clear();
                } else if (next_char == '\\') {
                    lexeme += next_char;
                    state = sstring_scaped;
                } else {
                    lexeme += next_char;
                }
                break;
            case ccharacter:
                if (next_char == '\\') {
                    lexeme += next_char;
                    next_char = get_next_char(&line_number);
                    if (next_char == 'r' || next_char == 'n' || next_char == 't' || next_char == 'b' ||
                        next_char == 'v' || next_char == '\\' || next_char == '\'' || next_char == '0' ||
                        next_char == 'a' || next_char == '?' || next_char == '\"') {
                        lexeme += next_char;
                        next_char = get_next_char(&line_number);
                        if (next_char == '\'') {
                            cout << "line " << line_number << ": char" << endl;
                            state = none;
                            lexeme.clear();
//                        cout << "line " << line_number << ": char \"" << lexeme << "\"" << endl;
                        } else {
                            state = error;
                        }
                    } else {
                        state = error;
                    }


                } else if (next_char != '\'') {
                    lexeme += next_char;
                    next_char = get_next_char(&line_number);
                    if (next_char == '\'') {
                        cout << "line " << line_number << ": char" << endl;
                        state = none;
                        lexeme.clear();
//                        cout << "line " << line_number << ": char \"" << lexeme << "\"" << endl;
                    } else {
                        state = error;
                    }
                } else {
                    state = error;
                }
                break;
            case sstring_scaped:

                if (next_char == 'r' || next_char == 'n' || next_char == 't' || next_char == 'b' ||
                    next_char == 'v' || next_char == '\\' || next_char == '\'' || next_char == '0' ||
                    next_char == 'a' || next_char == '?' || next_char == '\"') {
                    lexeme += next_char;
                    state = sstring;
                } else {
                    state = error;
                }

                break;
            case error:
                return 0;
                break;
        }

    }
    return 0;
}