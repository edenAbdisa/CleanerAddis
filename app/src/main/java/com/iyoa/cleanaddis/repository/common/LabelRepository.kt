package com.iyoa.cleanaddis.repository.common

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.posting.LabelDAO
import com.iyoa.cleanaddis.data.posting.LabelUUID

class LabelRepository (val labelDAO: LabelDAO) {
    fun getLabelByName(name: String): LabelUUID{
        return labelDAO.getLabelByName(name)
    }
}