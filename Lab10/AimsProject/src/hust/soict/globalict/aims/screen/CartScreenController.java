package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	
	private Cart cart;
	private Store store;
	
	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, String> colMediaCost;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	private Button btnPlay;
	
	@FXML
	private Button btnRemove;
	
	@FXML
	private TextField tfFilter;
	
	@FXML
	private RadioButton radioBtnFilterId;
	
	@FXML
	private RadioButton radioBtnFilterTitle;
	
	@FXML
	private Label lblTotalCost;
	
	
	public CartScreenController(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
	}
	
	@FXML
	private void initialize() {
		
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, String>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue,
							Media newValue) {
						if(newValue!=null) {
							updateButtonBar(newValue);
						}
					}
				});
		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,
					String newValue) {
				showFilteredMedia(newValue);
			}
		});
		lblTotalCost.setText(this.cart.totalCost() + " $");
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	
	void showFilteredMedia(String newValue) {
		FilteredList<Media> filterItems = new FilteredList<>(this.cart.getItemsOrdered(), media -> true);
		if(radioBtnFilterTitle.isSelected()) {
			filterItems.setPredicate(media -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				if(media.getTitle().toLowerCase().contains(newValue.toLowerCase())) {
					return true; 
				}
				else if(media.search(newValue)){ 
					return true; // this check for when you want to search with many tokens splited by space
				}				 // it means when you type st like "123 the 1234" it still shows results 
				else {
					return false; 
				}
			});
		}
		else {
			filterItems.setPredicate(media -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				if(media.getId() == Integer.parseInt(newValue)) {
					return true; 
				}			  
				else {
					return false; 
				}
			});
		}
		tblMedia.setItems(filterItems);
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		this.cart.removeMedia(media);
		lblTotalCost.setText(this.cart.totalCost() + " $");
	}
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		this.cart.emptyCart();
		lblTotalCost.setText(this.cart.totalCost() + " $");
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		new Dialog(media);
	}
	
	@FXML
	void viewStoreSelected(ActionEvent event) {
		new StoreScreen(this.store,this.cart);
	}
	
	@FXML
	void btnViewStorePressed(ActionEvent event) {
		new StoreScreen(this.store,this.cart);
	}
}
