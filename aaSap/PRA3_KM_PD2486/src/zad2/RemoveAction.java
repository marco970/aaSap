package zad2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class RemoveAction extends MouseAdapter{
	
	 private JList list;
     private DispList listModel;
       
     public RemoveAction(JList list, DispList listModel){
          this.list = list;
          this.listModel = listModel;
     }
       
     public void mouseClicked(MouseEvent e){
         if(e.isAltDown()){
             int index = list.locationToIndex(e.getPoint());
             if(index>-1)
                  listModel.remove(index);
         }
     }

}
