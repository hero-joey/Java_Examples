package com.hero.designpatten.memo.v1;

import java.util.Stack;

/**
 * @description: SnapshotHolder
 * @date: 2021/3/17 9:26
 * @author: maccura
 * @version: 1.0
 */
public class SnapshotHolder {
    private Stack<InputText> snapshots = new Stack<>();

    public InputText popSnapshot() {
        return  snapshots.pop();
    }

    public void pushSnapshot(InputText inputText) {
        InputText deepClonedInputText = new InputText();
        deepClonedInputText.setText(inputText.getText());
        snapshots.push(deepClonedInputText);

    }
}
