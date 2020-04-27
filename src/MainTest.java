import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class MainTest extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		stage.setTitle("Calculator");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Label title = new Label("Calculator");
		grid.add(title, 0, 1);
		
		TextField equationEnter = new TextField();
		grid.add(equationEnter, 1, 1);
		
		final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        
		Button enterBtn = new Button("Calculate");
		enterBtn.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {		        
		        ScriptEngineManager mgr = new ScriptEngineManager();
		        ScriptEngine engine = mgr.getEngineByName("JavaScript");
		        try {
					actiontarget.setText(engine.eval(equationEnter.getText()) + "");
				} catch (ScriptException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
		    }
		});
		grid.add(enterBtn, 0, 2);
		
		Scene scene = new Scene(grid, 300, 275);
		stage.setScene(scene);
		stage.show();
	}
	

}

