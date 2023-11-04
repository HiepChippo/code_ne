package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

import com.raven.datechooser.DateChooser;
import com.toedter.calendar.JDateChooser;

import commons.RoundPanel;
import commons.Table;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

import gui.Main_GUI;

import javax.print.DocFlavor.URL;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import java.awt.FlowLayout;
import javax.swing.JToolBar;

public class ThongKeLuongCongNhan_Form extends JPanel{
     

	private JPanel panelNorth;
	private JPanel panelSouth;
    private  int width = 1250;
    private  int height = 725;
	private DefaultTableModel model;
    private Table table_2;
    private Table tableThongKe;
	private JTextField textField;
	private JPanel panelBarChart;
	private JPanel panelLineChart;

	private RoundPanel panelCenter;
	public ThongKeLuongCongNhan_Form(int width, int height)
    { 
    	this.width = width;
    	this.height = height;
           initComponents();
           
           showBarChart();
//           showLineChart();
           showLineChart();
    }
           

	 public void showBarChart(){
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.setValue(200, "Amount", "january");
	        dataset.setValue(150, "Amount", "february");
	        dataset.setValue(18, "Amount", "march");
	        dataset.setValue(100, "Amount", "april");
	        dataset.setValue(80, "Amount", "may");
	        dataset.setValue(250, "Amount", "june");
	        
	        JFreeChart chart = ChartFactory.createBarChart("contribution","monthly","amount", 
	                dataset, PlotOrientation.VERTICAL, false,true,false);
	        
	        CategoryPlot categoryPlot = chart.getCategoryPlot();
	        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
	        categoryPlot.setBackgroundPaint(Color.WHITE);
	        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
	        Color clr3 = new Color(204,0,51);
	        renderer.setSeriesPaint(0, clr3);
	        
	        ChartPanel barpChartPanel = new ChartPanel(chart);
	        panelBarChart.removeAll();
	        panelBarChart.add(barpChartPanel, BorderLayout.SOUTH);
	        panelBarChart.validate();
	        
	        
	    }
//	 public void showPieChart(){
//	        
//	        //create dataset
//	      DefaultPieDataset barDataset = new DefaultPieDataset( );
//	      barDataset.setValue( "IPhone 5s" , new Double( 20 ) );  
//	      barDataset.setValue( "SamSung Grand" , new Double( 20 ) );   
//	      barDataset.setValue( "MotoG" , new Double( 40 ) );    
//	      barDataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
//	      
//	      //create chart
//	       JFreeChart piechart = ChartFactory.createPieChart("mobile sales",barDataset, false,true,false);//explain
//	      
//	        PiePlot piePlot =(PiePlot) piechart.getPlot();
//	      
//	       //changing pie chart blocks colors
//	       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
//	        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
//	        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
//	        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
//	      
//	       
//	        piePlot.setBackgroundPaint(Color.white);
//	        
//	        //create chartPanel to display chart(graph)
//	        ChartPanel barChartPanel = new ChartPanel(piechart);
//	        panelLineChart.removeAll();
//	        panelLineChart.add(barChartPanel, BorderLayout.CENTER);
//	        panelLineChart.validate();
//	    }
	 public void showLineChart(){
	        //create dataset for the graph
	         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.setValue(6000, "Amount", "january");
	        dataset.setValue(7000, "Amount", "february");
	        dataset.setValue(1800, "Amount", "march");
	        dataset.setValue(5000, "Amount", "april");
	        dataset.setValue(8000, "Amount", "may");
	        dataset.setValue(10000, "Amount", "june");
	        
	        //create ch
	        JFreeChart linechart = ChartFactory.createLineChart("contribution","monthly","amount", 
	                dataset, PlotOrientation.VERTICAL, false,true,false);
	        
	        //create plot object
	         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
	       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
	        lineCategoryPlot.setBackgroundPaint(Color.white);
	        
	        //create render object to change the moficy the line properties like color
	        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
	        Color lineChartColor = new Color(204,0,51);
	        lineRenderer.setSeriesPaint(0, lineChartColor);
	        
	         //create chartPanel to display chart(graph)
	        ChartPanel lineChartPanel = new ChartPanel(linechart);
	        lineChartPanel.setBounds(-27, 0, 629, 407);
	        panelLineChart.removeAll();
	        panelLineChart.setLayout(null);
	        panelLineChart.add(lineChartPanel);
	        panelLineChart.validate();
	    }
    public void initComponents()
    {
      setPreferredSize(new Dimension(1250, 778));
  	  setBackground(Color.decode("#004e92"));
  	  panelBarChart = new JPanel();
  	  panelBarChart.setBackground(new Color(255, 255, 255));
  	  panelBarChart.setBounds(31, 364, 571, 407);
  	   panelLineChart = new JPanel();
  	  panelLineChart.setBackground(new Color(255, 255, 255));
  	  panelLineChart.setBounds(612, 364, 612, 407);
  	  setLayout(null);
  	  add(panelBarChart);
  	  panelBarChart.setLayout(new BorderLayout(0, 0));
  	  add(panelLineChart);
      
   // Bảng chấm công
   		tableThongKe = new Table();
   		  tableThongKe.setOpaque(false);
           // Cài đặt header cho table Chấm công
   		    tableThongKe.setModel(new DefaultTableModel(
   		    	new Object[][] {
   		    		{"1", "2", "3", "4"},
   		    		{"2", null, null, null},
   		    		{null, null, null, null},
   		    		{null, null, null, null},
   		    		{null, null, null, null},
   		    	},
   		    	new String[] {
   		    		"ID ph\u00E2n x\u01B0\u1EDFng", "T\u00EAn ph\u00E2n x\u01B0\u1EDFng", "S\u1ED1 l\u01B0\u1EE3ng c\u00F4ng nh\u00E2n", "T\u1ED5ng L\u01B0\u01A1ng"
   		    	}
   		    ));
   		    tableThongKe.getColumnModel().getColumn(1).setPreferredWidth(92);
   		    tableThongKe.getColumnModel().getColumn(2).setPreferredWidth(89);
         
           JScrollPane scrollPane_TK = new JScrollPane();
           scrollPane_TK.setBackground(new Color(255, 255, 255));
           scrollPane_TK.setOpaque(false);
           scrollPane_TK.setBorder(new EmptyBorder(5, 5, 5, 5));
           scrollPane_TK.setViewportView(tableThongKe);
           scrollPane_TK.setBounds(10, 10, 1173, 259);
           tableThongKe.fixTable(scrollPane_TK);
           panelCenter = new RoundPanel();
   		   panelCenter.setRound(20);
   		   panelCenter.setBackground(new Color(255, 255, 255));
   		   panelCenter.setBorder(new EmptyBorder(5, 15, 10, 10));
   		   panelCenter.setBounds(31, 75, 1193, 279);
           add(panelCenter);
           panelCenter.setLayout(null);
           panelCenter.add(scrollPane_TK);
   
           

      JPanel pNorth = new JPanel();
      pNorth.setBounds(31, 10, 1198, 55);
      add(pNorth);
      pNorth.setLayout(null);
      
      JComboBox cbThang = new JComboBox();
      cbThang.setFont(new Font("Tahoma", Font.PLAIN, 15));
      cbThang.setBounds(93, 15, 83, 28);
      String data[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
      cbThang.setModel(new DefaultComboBoxModel<String>(data));
      pNorth.add(cbThang);
      
      JComboBox cbNam = new JComboBox();
      cbNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
      cbNam.setBounds(272, 15, 181, 28);
      String data_1[] = {"2023"};
      cbNam.setModel(new DefaultComboBoxModel<String>(data_1));
      pNorth.add(cbNam);
      
      JButton btnThongKe = new JButton("Thống kê");
      btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnThongKe.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      btnThongKe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThongKeLuongCongNhan_Form.class.getResource("/icon/thongKe.png")).getScaledInstance(30, 25,Image.SCALE_SMOOTH)));
      
      
      btnThongKe.setBounds(484, 10, 154, 38);
      pNorth.add(btnThongKe);
      
      JButton btnXuatExcel = new JButton("Xuất ra excel");
      btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnXuatExcel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThongKeLuongCongNhan_Form.class.getResource("/icon/excel.png")).getScaledInstance(30, 25,Image.SCALE_SMOOTH)));

      btnXuatExcel.setBounds(663, 10, 160, 38);
      pNorth.add(btnXuatExcel);
      
      JLabel lbthang = new JLabel("Tháng:");
      lbthang.setFont(new Font("Tahoma", Font.PLAIN, 15));
      lbthang.setHorizontalAlignment(SwingConstants.CENTER);
      lbthang.setBounds(36, 19, 58, 20);
      pNorth.add(lbthang);
      
      JLabel lbNam = new JLabel("Năm:");
      lbNam.setHorizontalAlignment(SwingConstants.CENTER);
      lbNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
      lbNam.setBounds(215, 19, 58, 20);
      pNorth.add(lbNam);
      
      
      
      
    }
}

