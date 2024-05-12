package Menu2_Laundry;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Renderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // atur text di tengah
        setHorizontalAlignment(CENTER);

        // atur text jadi bold
        setFont(getFont().deriveFont(getFont().getStyle() | java.awt.Font.BOLD));

        return component;
    }

    public static void setCenterBoldColumnHeaders(JTable table) {
        TableColumnModel columnModel = table.getTableHeader().getColumnModel();
        for (int columnIndex = 0; columnIndex < columnModel.getColumnCount(); columnIndex++) {
            columnModel.getColumn(columnIndex).setHeaderRenderer(new Renderer());
        }
    }

    public static void setColumnSeparators(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setHeaderRenderer(new Renderer());
            column.setCellRenderer(new Renderer());
            column.setPreferredWidth(150);
            column.setResizable(true);
            column.setMaxWidth(300);
        }

        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setGridColor(java.awt.Color.gray);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray));
    }
}
