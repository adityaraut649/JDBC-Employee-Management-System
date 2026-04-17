package Employeemanegment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.*;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DeleteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFrame frame = new DeleteFrame();
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
	public DeleteFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Delete Employee");
		lblNewLabel.setBackground(SystemColor.inactiveCaption);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		lblNewLabel.setBounds(147, 11, 125, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBackground(SystemColor.activeCaption);
		lblNewLabel_1.setBounds(102, 81, 85, 29);
		contentPane.add(lblNewLabel_1);

		id = new JTextField();
		id.setBounds(233, 84, 86, 26);
		contentPane.add(id);
		id.setColumns(10);

		JButton btnNewButton = new JButton("Delete ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement ps = null;
				String sql = "DELETE FROM employee WHERE id = ?";
				String url = "jdbc:mysql://localhost:3306/employee";
				String dpath = "com.mysql.cj.jdbc.Driver";
				String user = "root";
				String password = "Aditya@123";

				try {
					Class.forName(dpath);
					con = DriverManager.getConnection(url, user, password);
					ps = con.prepareStatement(sql);
					int inid = Integer.parseInt(id.getText());

					ps.setInt(1, inid);
					int nor = ps.executeUpdate();
					if (nor > 0) {
						JOptionPane.showMessageDialog(DeleteFrame.this, "Data Deleted Successfully!");
						id.setText("");
					}
					con.close();
					ps.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(98, 186, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnBack = new JButton("BACK ");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomeFrame().setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(233, 186, 89, 23);
		contentPane.add(btnBack);

	}

}
