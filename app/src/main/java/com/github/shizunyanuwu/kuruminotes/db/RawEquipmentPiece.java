package com.github.shizunyanuwu.kuruminotes.db;

import com.github.shizunyanuwu.kuruminotes.data.EquipmentPiece;

public class RawEquipmentPiece {
    public int equipment_id;
    public String equipment_name;

    public EquipmentPiece getEquipmentPiece() {
        return new EquipmentPiece(equipment_id, equipment_name);
    }
}
