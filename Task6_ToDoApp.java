import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Task6_ToDoApp {
    private JFrame frame;
    private JTextField taskField;
    private JButton addButton, deleteButton;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private ArrayList<String> tasks;

    public Task6_ToDoApp() {
        tasks = new ArrayList<>();

        // Frame setup
        frame = new JFrame("To-Do List App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top panel for input
        JPanel topPanel = new JPanel();
        taskField = new JTextField(20);
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");

        topPanel.add(taskField);
        topPanel.add(addButton);
        topPanel.add(deleteButton);

        // List model & JList
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Add listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    tasks.add(task); // Store in ArrayList
                    listModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    tasks.remove(selectedIndex); // Remove from ArrayList
                    listModel.remove(selectedIndex);
                }
            }
        });

        // Add components to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Task6_ToDoApp();
    }
}
