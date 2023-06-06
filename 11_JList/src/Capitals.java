
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Capitals extends JFrame {

    private JTextField input;

    private JList<String> list;

    private CustomListModel model;

    public Capitals() {

        super("App2");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(300, 400);

        setLayout(new BorderLayout());

        input = new JTextField("");

        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = input.getText();

                if (!text.isEmpty() && !model.contains(text)) {

                    model.add(text);

                    input.setText("");
                }
            }
        });

        add(input, BorderLayout.NORTH);

        model = new CustomListModel();

        list = new JList<>(model);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    String[] values = list.getSelectedValuesList().toArray(new String[0]);
                    System.out.println("Selected values: " + String.join(", ", values));
                }
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        model.remove(index);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(list);

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        Capitals capitals = new Capitals();
    }

    class CustomListModel extends AbstractListModel<String> implements Comparable<CustomListModel> {

        private ArrayList<String> data;

        public CustomListModel() {
            data = new ArrayList<>();
        }

        @Override
        public int getSize() {
            return data.size();
        }

        @Override
        public String getElementAt(int index) {
            return data.get(index);
        }

        @Override
        public int compareTo(CustomListModel other) {
            return this.getElementAt(0).compareTo(other.getElementAt(0));
        }

        public void add(String element) {
            if (data.isEmpty()) {

                data.add(element);
                fireIntervalAdded(this, data.size() - 1, data.size() - 1);

            } else {

                CustomListModel temp = new CustomListModel();
                temp.data.add(element);

                for (int i = 0; i < data.size(); i++) {

                    CustomListModel current = new CustomListModel();
                    current.data.add(data.get(i));

                    int result = temp.compareTo(current);

                    if (result <= 0) {

                        data.add(i, element);

                        fireIntervalAdded(this, i, i);

                        break;
                    }

                    if (result > 0 && i == data.size() - 1) {

                        data.add(element);

                        fireIntervalAdded(this, data.size() - 1, data.size() - 1);

                        break;
                    }
                }
            }
        }

        public void remove(int index) {

            data.remove(index);

            fireIntervalRemoved(this, index, index);
        }

        public boolean contains(String element) {
            return data.contains(element);
        }
    }
}
