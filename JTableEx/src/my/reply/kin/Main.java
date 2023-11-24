package my.reply.kin;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class Main extends JFrame {

	public static void main(String[] args) {
	    new Main();
	}

	Dimension sz = new Dimension(600,400);
	JTable exTable;

	Main() {
	    super("JTable 지식iN 답변");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setMinimumSize(sz);
	    setMaximumSize(sz);
	    setLocationRelativeTo(null);

	    drawGUI();
		addListener();
	    setData();
	    setVisible(true);
	}

	private void drawGUI() {
	    Vector colNames = new Vector();
	    colNames.add("줄 번호");
	    colNames.add("종류");
	    colNames.add("이름");

	    exTable = new JTable(new Vector(), colNames);
	    exTable.getTableHeader().setPreferredSize(new Dimension(sz.width, 32));
	    exTable.setRowHeight(32);

		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				switch (column) {
					case 0:
						setHorizontalAlignment(SwingConstants.RIGHT);
						setText(value + " ");
						break;
					case 1:
					case 2:
						setHorizontalAlignment(SwingConstants.CENTER);
						setText((String)value);
						break;
				}
				setBackground(isSelected? Color.cyan : Color.white);
				return this;
			}
		};
		exTable.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		exTable.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		exTable.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		exTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    add("Center", new JScrollPane(exTable));
	}

	private void printSelectedRowData() {
		int selectIdx = exTable.getSelectedRow();
		Vector rowData = ((DefaultTableModel) exTable.getModel()).getDataVector().get(selectIdx);
		System.out.println(rowData);
	}

	private void addListener() {
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				printSelectedRowData();
			}
		};
		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				printSelectedRowData();
			}
		};

		exTable.addMouseListener(mouseAdapter);
		exTable.addKeyListener(keyAdapter);
	}

	private void setData() {
	    DefaultTableModel dataModel = (DefaultTableModel) exTable.getModel();
	    dataModel.addRow(new Object[]{"1", "과자", "맛동산"});
		dataModel.addRow(new Object[]{"2", "과자", "빼뺴로"});
		dataModel.addRow(new Object[]{"3", "과자", "누네띠네"});
		dataModel.addRow(new Object[]{"4", "과자", "새우깡"});
		dataModel.addRow(new Object[]{"5", "과자", "조청유과"});
		dataModel.addRow(new Object[]{"6", "과자", "사브레"});
		dataModel.addRow(new Object[]{"7", "과자", "초이스"});
		dataModel.addRow(new Object[]{"8", "과자", "고래밥"});
		dataModel.addRow(new Object[]{"9", "과자", "양파링"});
		dataModel.addRow(new Object[]{"10", "과자", "도도한 나쵸"});
		dataModel.addRow(new Object[]{"11", "과자", "프링글스"});
		dataModel.addRow(new Object[]{"12", "과자", "후렌치파이"});
		dataModel.addRow(new Object[]{"13", "과자", "카스타드"});
		dataModel.addRow(new Object[]{"14", "과자", "뽀또"});
		dataModel.addRow(new Object[]{"15", "과자", "마가레뜨"});
		dataModel.addRow(new Object[]{"16", "과자", "닭다리"});
		dataModel.addRow(new Object[]{"17", "과자", "포카칩"});
		dataModel.addRow(new Object[]{"18", "과자", "롯데와플"});
		dataModel.addRow(new Object[]{"19", "과자", "산도"});
		dataModel.addRow(new Object[]{"20", "과자", "갸또"});
	}

}
