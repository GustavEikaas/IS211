package editor.action;

import java.awt.event.ActionEvent;

import editor.Editor;
import editor.Document;

public class RemoveAction extends EditorAction {

	Editor editor;

    public RemoveAction(String name, Editor ed) {
        super(name);
        this.editor = ed;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Document doc = editor.getDocument();
		System.out.println(e.getActionCommand());
		doc.removeChar();
		
	}
}
