import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private int line_count;
    private IR_Line[] program;
    private Map<Integer, Integer> map = new HashMap<>();
    private Map<Integer, Integer> matrix_map = new HashMap<>();
    private Map<Integer, Integer> reverse_matrix_map = new HashMap<>();

    private void start() {
        scan_input();

        program[0].is_cfg_node = true;

        for (int i = 0; i < line_count; i++) {
            switch (program[i].type) {
                case normal_opcode:
                    if (i < line_count - 1) {
                        program[i].target_byte_number_2 = program[i + 1].byte_number;
                    }
                    break;
                case conditional_branch:
                    if (i < line_count - 1) {
                        program[i].target_byte_number_2 = program[i + 1].byte_number;
                        program[i + 1].is_cfg_node = true;
                    }
                    program[map.get(program[i].target_byte_number_1)].is_cfg_node = true;
                    break;
                case unconditional_branch:
                    if (i < line_count - 1) {
                        program[i + 1].is_cfg_node = true;
                    }
                    program[map.get(program[i].target_byte_number_1)].is_cfg_node = true;
                    break;
                case terminating_opcode:
                    if (i < line_count - 1) {
                        program[i + 1].is_cfg_node = true;
                    }
                    break;
            }
        }

        int node_count = 0;
        for (int i = 0; i < line_count; i++) {
            if (program[i].is_cfg_node) {
                matrix_map.put(i, node_count);
                reverse_matrix_map.put(node_count, i);
                node_count += 1;
            }
        }

//        System.out.println(node_count);

        int[][] matrix = new int[node_count][node_count];

        for (int i = 0; i < node_count; i++) {
            for (int j = 0; j < node_count; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < line_count; i++) {
            if (program[i].is_cfg_node) {
                int matrix_x = matrix_map.get(i);
                int end_line;
                if (matrix_x == node_count - 1) {
                    end_line = line_count - 1;
                } else {
                    end_line = reverse_matrix_map.get(matrix_x + 1) - 1;
                }

                if (program[end_line].type == OpType.unconditional_branch || program[end_line].type == OpType.conditional_branch) {
                    int matrix_y = matrix_map.get(map.get(program[end_line].target_byte_number_1));
                    matrix[matrix_x][matrix_y] = 1;
                }
                if (program[end_line].type == OpType.conditional_branch || program[end_line].type == OpType.normal_opcode) {
                    int matrix_y = matrix_map.get(map.get(program[end_line].target_byte_number_2));
                    matrix[matrix_x][matrix_y] = 1;
                }

            }
        }


        for (int i = 0; i < node_count; i++) {
            for (int j = 0; j < node_count; j++) {
                System.out.print(matrix[i][j]);
                if (j != node_count - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }


    }

    private void scan_input() {
        line_count = scanner.nextInt();
        program = new IR_Line[line_count];
        scanner.nextLine();

        for (int i = 0; i < line_count; i++) {
            program[i] = new IR_Line(scanner.nextLine());
            map.put(program[i].byte_number, i);
        }

        while (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        new Main().start();
    }

    public enum OpType {normal_opcode, conditional_branch, unconditional_branch, terminating_opcode}

    static OpType find_op_type(String opcode) {
        if (opcode.endsWith("return") || opcode.endsWith("throw")) {
            return OpType.terminating_opcode;
        } else if (opcode.startsWith("goto") || opcode.startsWith("jsr")) {
            return OpType.unconditional_branch;
        } else if (opcode.startsWith("if")) {
            return OpType.conditional_branch;
        } else {
            return OpType.normal_opcode;
        }
    }
}

class IR_Line {
    int byte_number;
    Main.OpType type;
    int target_byte_number_1 = -1;
    int target_byte_number_2 = -1;
    boolean is_cfg_node = false;

    IR_Line(String line) {
        String line1 = line.substring(line.indexOf(':') + 2, line.length());
        byte_number = Integer.parseInt(line.substring(0, line.indexOf(':')));
        String opcode = line1.split("\\s+")[0];
        this.type = Main.find_op_type(opcode);
        if (this.type == Main.OpType.conditional_branch || this.type == Main.OpType.unconditional_branch) {
            this.target_byte_number_1 = Integer.parseInt(line1.split("\\s+")[1]);
        }
    }
}

