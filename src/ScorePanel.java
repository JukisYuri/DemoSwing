package EX26;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

public class ScorePanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private JTextField fieldMSSV, fieldTenSV, fieldMaMH, fieldTenMH, fieldDiem;
    private Map<String, Student> students;
    private JComboBox<Course> comboBoxTenMH;

    public ScorePanel(Map<String, Student> students) {
        this.students = students;
        setLayout(new BorderLayout());

        // Phần Thêm Môn Học
        JPanel panelTTSV2 = new JPanel(new GridLayout(4, 2));
        panelTTSV2.setBorder(BorderFactory.createTitledBorder("Thêm Môn Học"));

        JLabel labelMSSV = new JLabel("MSSV", JLabel.RIGHT);
        fieldMSSV = new JTextField();
        JLabel labelTenSV = new JLabel("Họ Và Tên", JLabel.RIGHT);
        fieldTenSV = new JTextField();
        JLabel labelTenMH = new JLabel("Tên Môn Học", JLabel.RIGHT);
        comboBoxTenMH = new JComboBox<>(new Vector<>()); // Fix this
        JLabel labelDiem = new JLabel("Điểm", JLabel.RIGHT);
        fieldDiem = new JTextField();

        panelTTSV2.add(labelMSSV);
        panelTTSV2.add(fieldMSSV);
        panelTTSV2.add(labelTenSV);
        panelTTSV2.add(fieldTenSV);
        panelTTSV2.add(labelTenMH);
        panelTTSV2.add(comboBoxTenMH);
        panelTTSV2.add(labelDiem);
        panelTTSV2.add(fieldDiem);

        // Phần Thao Tác
        JPanel panelButton2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelButton2.setBorder(BorderFactory.createTitledBorder("Thao Tác"));
        panelButton2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton buttonThemDiem = new JButton("Thêm Điểm");
        JButton buttonTimSV2 = new JButton("Tìm Sinh Viên");

        panelButton2.add(buttonThemDiem);
        panelButton2.add(buttonTimSV2);

        // Phần Table - TableProgress
        model = new DefaultTableModel(new Object[]{"Số TT", "Tên môn học", "Điểm"}, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        TableProgress tableProgress = new TableProgress(students, fieldMSSV, fieldTenSV, fieldMaMH, fieldTenMH, fieldDiem, model, comboBoxTenMH);

        buttonTimSV2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableProgress.searchStudent();
            }
        });

        buttonThemDiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableProgress.addScore();
            }
        });

        add(panelTTSV2, BorderLayout.NORTH);
        add(panelButton2, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);
    }
}
