package com.hero.designpatten.memo.v2;

import java.util.Stack;

/**
 * @description: SnapshotHolder
 * @date: 2021/3/17 9:26
 * @author: maccura
 * @version: 1.0
 */
public class SnapshotHolder {
    private Stack<SnapShot> snapshots = new Stack<>();

    public SnapShot popSnapshot() {
        return  snapshots.pop();
    }

    public void pushSnapshot(SnapShot snapShot) {
        snapshots.push(snapShot);
    }
}
