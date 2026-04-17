package Employeemanegment;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FetchFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTable table_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FetchFrame frame = new FetchFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FetchFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Fetch Employee");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel.setBounds(142, 11, 160, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(133, 66, 87, 27);
		contentPane.add(lblNewLabel_1);

		id = new JTextField();
		id.setBounds(230, 67, 93, 27);
		contentPane.add(id);

		JButton btnFetch = new JButton("FETCH");
		btnFetch.setBackground(SystemColor.activeCaption);
		btnFetch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnFetch.setBounds(230, 121, 89, 23);
		contentPane.add(btnFetch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 177, 384, 44);
		contentPane.add(scrollPane);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Gender", "Salary" }));
		scrollPane.setViewportView(table_2);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomeFrame().setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(110, 122, 89, 23);
		contentPane.add(btnBack);

		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetchEmployee();
			}
		});
	}

	private void fetchEmployee() {
		try {
			int searchId = Integer.parseInt(id.getText());

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Aditya@123");

			String sql = "SELECT * FROM employee WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, searchId);

			ResultSet rs = pst.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table_2.getModel();
			model.setRowCount(0);

			if (rs.next()) {
				model.addRow(new Object[] { rs.getInt("id"), rs.getString("name"), rs.getString("gender"),
						rs.getDouble("salary") });
			} else {
				JOptionPane.showMessageDialog(this, "No employee found with ID: " + searchId);
			}

			con.close();

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Please enter a valid ID");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
