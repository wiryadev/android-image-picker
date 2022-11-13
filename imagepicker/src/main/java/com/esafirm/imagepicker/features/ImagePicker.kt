package com.esafirm.imagepicker.features

import android.content.Intent
import android.os.Build
import com.esafirm.imagepicker.features.cameraonly.ImagePickerCameraOnly
import com.esafirm.imagepicker.model.Image

object ImagePicker {
    fun cameraOnly(): ImagePickerCameraOnly {
        return ImagePickerCameraOnly()
    }

    /* --------------------------------------------------- */
    /* > Helper */
    /* --------------------------------------------------- */

    @Deprecated("This method will marked internal soon. Please use the new API")
    fun getImages(intent: Intent?): List<Image>? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableArrayListExtra(IpCons.EXTRA_SELECTED_IMAGES, Image::class.java)
        } else {
            intent?.getParcelableArrayListExtra(IpCons.EXTRA_SELECTED_IMAGES)
        }
    }
}