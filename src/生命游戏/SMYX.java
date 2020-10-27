package 生命游戏;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;

public class SMYX extends JFrame {

	private JPanel contentPane;
	private CELL cell=new CELL();
	private JButton[][] ButtonArr=new JButton[cell.length][cell.length];
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SMYX frame = new SMYX();
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
	public void init() {
		ButtonArr = new JButton[cell.length][cell.length];
		 for (int i = 0; i < cell.length; i++) {
	            for (int j = 0; j < cell.length; j++) {
	            	ButtonArr[i][j] = new JButton(""); //按钮内容置空以表示细胞
	            	
	            	int a=i,b=j;
	            	ButtonArr[i][j].addMouseListener(new MouseAdapter() {
	        			@Override
	        			public void mouseClicked(MouseEvent e) {
	        				cell.matrix[a][b]=cell.matrix[a][b]^1;
	        				printCELL();
	        				
	        			}
	        		
	        		});
	            	ButtonArr[i][j].setBounds(cell.cellSize*j, cell.cellSize*i, cell.cellSize, cell.cellSize);
	                contentPane.add(ButtonArr[i][j]);
	                }
		 }
	}
	public void printCELL()
	{    

		 for (int i = 0; i < cell.length; i++) {
	            for (int j = 0; j < cell.length; j++) {
	        
	            	if(cell.matrix[i][j]==1)
	            	{
	            		ButtonArr[i][j].setBackground(Color.white);
	            	}
	            	else
	            	{
	            		ButtonArr[i][j].setBackground(Color.black);
	            	}
	      
	           }
		 }
	}
	
	public SMYX() throws AWTException {
		setTitle("\u751F\u547D\u6E38\u620F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FED\u4EE3");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				cell.change();
				printCELL();
				
			}
		
		});
		
		
		cell.initMatrix();
		cell.setCell();
		init();
		printCELL();
		

		btnNewButton.setBounds(1000, 120, 100, 100);
		contentPane.add(btnNewButton);
	}
}
