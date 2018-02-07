
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new FirstFollow().start();
    }
}

class FirstFollow {
    private Scanner scanner = new Scanner(System.in);
    private int number_of_lines;
    private ArrayList<String[]> rules = new ArrayList<>();
    private Map<String, ArrayList<String>> firsts_dictionary = new LinkedHashMap<>();
    private Map<String, ArrayList<String>> follows_dictionary = new LinkedHashMap<>();
    private int[][] ll1_pars_table = new int[26][41];
    private int[] non_terminal_nelle_rule = new int[26];
    private String starting_non_terminal;

    void start() {
        scan_rules_data();
        Arrays.fill(non_terminal_nelle_rule, -1);
        build_first_set();
        build_follow_set();
//        print_set(firsts_dictionary);
//        print_set(follows_dictionary);
        add_nelle_rules();
        pars_program();
    }

    private void pars_program() {
        StringBuilder input_rest = new StringBuilder("");
        while (scanner.hasNext()) {
            input_rest.append(scanner.next());
        }
        String pre_program  = input_rest.toString().replaceAll("[\\s]+", "");


        char[] program = (pre_program + "$").toCharArray();
        int program_index = 0;
        Stack<String> parser_stack = new Stack<>();
        parser_stack.push("$");
        parser_stack.push(starting_non_terminal);
        StringBuilder result = new StringBuilder();

        while (program_index < program.length) {
            if (is_terminal(parser_stack.peek().charAt(0))) {
                parser_stack.pop();
                program_index++;
            } else {
                int rule_id = ll1_pars_table[get_non_terminal_id_by_character(parser_stack.peek().charAt(0))]
                        [get_terminal_id_by_character(program[program_index])];
                String[] rule = rules.get(rule_id);
                result.append(rule_id + 1);
                result.append(" ");

                parser_stack.pop();
                for (int i = rule.length - 1 ; i > 1 ; i--) {
                    if (! rule[i].equals("#")) {
                        parser_stack.push(rule[i]);
                    }
                }
            }
        }
        System.out.println(result.substring(0, result.length() - 1));
    }
    private void add_nelle_rules() {
        for (String key: firsts_dictionary.keySet()) {
            if (firsts_dictionary.get(key).contains("#")) {
                int nelle_rule_number = non_terminal_nelle_rule[get_non_terminal_id_by_character(key.charAt(0))];
                int i_index = get_non_terminal_id_by_character(key.charAt(0));
                for(String follow_member: follows_dictionary.get(key)) {
                    int j_index = get_terminal_id_by_character(follow_member.charAt(0));
                    ll1_pars_table[i_index][j_index] = nelle_rule_number;
                }
            }
        }
    }
    private void scan_rules_data() {
        number_of_lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number_of_lines; i++) {
            String grammar_rule = scanner.nextLine();
            String[] rule = grammar_rule.split("\\s");
            rules.add(rule);
            if (!firsts_dictionary.containsKey(rule[0])) {
                firsts_dictionary.put(rule[0], new ArrayList<>());
                ArrayList<String> follows_list = new ArrayList<>();
                if (i == 0) {
                    follows_list.add("$");
                    starting_non_terminal = rule[0];
                }
                follows_dictionary.put(rule[0], follows_list);

            }
        }
    }
    private void print_set(Map<String, ArrayList<String>> set_dictionary) {
        for (String key : set_dictionary.keySet()) {
            ArrayList<String> sorted_first_set = set_dictionary.get(key);
            sorted_first_set.sort(String::compareTo);
            for (int i = 0; i < sorted_first_set.size(); i++) {
                if (i == sorted_first_set.size() - 1) {
                    System.out.println(sorted_first_set.get(i));
                } else {
                    System.out.print(sorted_first_set.get(i) + " ");
                }

            }
        }
    }
    private void build_first_set() {
        boolean repeat_needed = false;
        for (int i = 0; i < number_of_lines; i++) {
            repeat_needed = build_first_set_consider_rule(rules.get(i), i) || repeat_needed;
        }

        if (repeat_needed) {
            build_first_set();
        }
    }
    private boolean build_first_set_consider_rule(String[] rule, int rule_number) {
        boolean made_changes = false;
        for (int i = 2; i < rule.length; i++) {
            boolean break_for = true;
            if (is_terminal(rule[i].charAt(0)) || rule[i].equals("#")) {
                if (!firsts_dictionary.get(rule[0]).contains(rule[i])) {
                    ArrayList<String> updated_list = firsts_dictionary.get(rule[0]);
                    updated_list.add(rule[i]);
                    firsts_dictionary.put(rule[0], updated_list);
                    made_changes = true;

                    if (rule[i].equals("#")) {
                        non_terminal_nelle_rule[get_non_terminal_id_by_character(rule[0].charAt(0))] = rule_number;
                    } else {
                        ll1_pars_table[get_non_terminal_id_by_character(rule[0].charAt(0))]
                                [get_terminal_id_by_character(rule[i].charAt(0))] = rule_number;
                    }
                }
                break;
            } else {
                for (String first_member : firsts_dictionary.get(rule[i])) {
                    break_for = true;
                    if (!firsts_dictionary.get(rule[0]).contains(first_member)) {
                        if ((!first_member.equals("#")) || first_member.equals("#") && (i == rule.length - 1)) {
                            ArrayList<String> updated_list = firsts_dictionary.get(rule[0]);
                            updated_list.add(first_member);
                            firsts_dictionary.put(rule[0], updated_list);
                            made_changes = true;

                            if (first_member.equals("#") && (i == rule.length - 1)) {
                                non_terminal_nelle_rule[get_non_terminal_id_by_character(rule[0].charAt(0))] = rule_number;
                            } else {
                                ll1_pars_table[get_non_terminal_id_by_character(rule[0].charAt(0))]
                                        [get_terminal_id_by_character(first_member.charAt(0))] = rule_number;
                            }
                        }
                        if (first_member.equals("#")) {
                            break_for = false;
                        }
                    }
                }
                if (break_for) {
                    break;
                }
            }
        }
        return made_changes;
    }
    private void build_follow_set() {
        boolean repeat_needed = false;

        // TODO_DONE add $ to starting non-terminal follow set

        for (int i = 0; i < number_of_lines; i++) {
            repeat_needed = build_follow_set_consider_rule(rules.get(i)) || repeat_needed;
        }

        if (repeat_needed) {
            build_follow_set();
        }
    }
    private boolean build_follow_set_consider_rule(String[] rule) {
        boolean made_changes = false;

        for (int i = 2; i < rule.length; i++) {
            if (is_terminal(rule[i].charAt(0))) continue;
            if (i == rule.length - 1) {
                if (! rule[i].equals("#")) {
                    for (String follow_member : follows_dictionary.get(rule[0])) {
                        if (! follows_dictionary.get(rule[i]).contains(follow_member)) {
                            ArrayList<String> updated_list = follows_dictionary.get(rule[i]);
                            updated_list.add(follow_member);
                            follows_dictionary.put(rule[i], updated_list);
                            made_changes = true;
                        }
                    }
                }
                // TODO_DONE add all rule[0] follows to rule[i] follow
            } else {
                if (is_terminal(rule[i + 1].charAt(0))) {
                    if (! follows_dictionary.get(rule[i]).contains(rule[i + 1])) {
                        ArrayList<String> updated_list = follows_dictionary.get(rule[i]);
                        updated_list.add(rule[i+1]);
                        follows_dictionary.put(rule[i], updated_list);
                        made_changes = true;
                    }
                    // TODO_DONE add rule[i+1] to rule[i] follows
                } else {
                    boolean must_add_follows = false;
                    for (String first_member : firsts_dictionary.get(rule[i + 1])) {
                        if (first_member.equals("#")) {
                            must_add_follows = true;
                        } else if (! follows_dictionary.get(rule[i]).contains(first_member)) {
                            ArrayList<String> updated_list = follows_dictionary.get(rule[i]);
                            updated_list.add(first_member);
                            follows_dictionary.put(rule[i], updated_list);
                            made_changes = true;
                        }
                    }
                    if (must_add_follows) {
                        for (String follow_member : follows_dictionary.get(rule[i + 1])) {
                            if (! follows_dictionary.get(rule[i]).contains(follow_member)) {
                                ArrayList<String> updated_list = follows_dictionary.get(rule[i]);
                                updated_list.add(follow_member);
                                follows_dictionary.put(rule[i], updated_list);
                                made_changes = true;
                            }
                        }
                    }
                    // TODO_DONE ADD rule[i+1] firsts to rule[i] follow
                    // TODO_DONE if # is in rule[i+1] firsts don't add it and add rule [i+1] follows to rule[i] follow
                }
            }
        }

        return made_changes;
    }
    private boolean is_terminal(char input) {
        return input >= 'a' && input <= 'z' || input >= '1' && input <= '9'
                || input == '*' || input == '+' || input == '-' || input == '(' || input == ')' || input == '$';
    }
    private int get_non_terminal_id_by_character(char character) {
        return character - 'A';
    }
    private int get_terminal_id_by_character(char character) {
        switch (character) {
            case '(':
                return 0;
            case ')':
                return 1;
            case '*':
                return 2;
            case '+':
                return 3;
            case '-':
                return 4;
            case '$':
                return 40;
            default:
                if (character >= '1' && character <= '9') {
                    return character - '0' + 5;
                } else {
                    return character - 'a' + 14;
                }
        }
    }
}
