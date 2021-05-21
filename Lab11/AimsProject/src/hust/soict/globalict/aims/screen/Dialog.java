package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Dialog extends JDialog{
	private Media media;
	
	public Dialog(Media media) {
		this.media = media;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel pn = new JPanel();
		JLabel lb1 = new JLabel();
		JLabel lb2 = new JLabel();
		if(media instanceof CompactDisc) {
			if(((CompactDisc)media).getLength() != 0) {
				lb1.setText("Playing CD: " + media.getTitle());
				lb2.setText("CD length: " + ((CompactDisc) media).getLength());
				pn.add(lb1);
				pn.add(lb2);
				for (int i = 0; i < ((CompactDisc) media).tracks.size(); i++) {
					pn.add(new JLabel("		Track: " + ((CompactDisc) media).tracks.get(i).getTitle()));
					pn.add(new JLabel("		Length: " + ((CompactDisc) media).tracks.get(i).getLength()));
				}
			}
			else {
				pn.add(new JLabel("Cannot play this CD: "+ media.getTitle()));
			}
		}
		else {
			if(((DigitalVideoDisc)media).getLength() != 0) {
				lb1.setText("Playing DVD: " + media.getTitle());
				lb2.setText("DVD length: " + ((DigitalVideoDisc) media).getLength());
				pn.add(lb1);
				pn.add(lb2);
			}
			else {
				pn.add(new JLabel("Cannot play this DVD: "+ media.getTitle()));
			}
		}
		cp.add(pn, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Play");
		this.setSize(235, 200);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocation(400, 300);
	}
}