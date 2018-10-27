package zad3;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

public class TableMouseListener extends MouseAdapter {
    
   private JTable table;
    
   public TableMouseListener(JTable table) {
       this.table = table;
   }
    
   @Override
   public void mousePressed(MouseEvent event) {
       Point point = event.getPoint();
       int currentRow = table.rowAtPoint(point);
       table.setRowSelectionInterval(currentRow, currentRow);
   }
}
