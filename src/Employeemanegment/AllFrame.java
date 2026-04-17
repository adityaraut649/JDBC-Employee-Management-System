package Employeemanegment;

import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AllFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllFrame frame = new AllFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AllFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("All Employees ");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel.setBounds(148, 11, 123, 28);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 50, 378, 165);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomeFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(83, 226, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root",
							"Aditya@123");

					String sql1 = "SELECT * FROM employee";
					PreparedStatement ps1 = con.prepareStatement(sql1);
					ResultSet rs = ps1.executeQuery();

					// IMPORTANT: get model
					DefaultTableModel model = new DefaultTableModel();
					table.setModel(model);

					// Metadata (column info)
					ResultSetMetaData rsmd = rs.getMetaData();
					int cols = rsmd.getColumnCount();

					// Column names
					String[] colNames = new String[cols];
					for (int i = 0; i < cols; i++) {
						colNames[i] = rsmd.getColumnName(i + 1);
					}
					model.setColumnIdentifiers(colNames);

					// Row data (THIS WAS MISSING)
					while (rs.next()) {
						Object[] row = new Object[cols];
						for (int i = 0; i < cols; i++) {
							row[i] = rs.getObject(i + 1);
						}
						model.addRow(row);
					}

					con.close();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnDisplay.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDisplay.setBackground(SystemColor.activeCaption);
		btnDisplay.setBounds(247, 226, 97, 23);
		contentPane.add(btnDisplay);
	}
}
