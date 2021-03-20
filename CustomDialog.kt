private fun showConfirmationDialog() {
    val confirmationDialog = Dialog(requireContext(), R.style.DialogTheme)
    val dialogView = LayoutInflater.from(activity).inflate(R.layout.confirmation_dialog_layout, root, false)
    val deleteButton: TextView = dialogView.findViewById(R.id.delete_button)
    val cancelButton: TextView = dialogView.findViewById(R.id.cancel_button)

    cancelButton.setOnClickListener {
        confirmationDialog.dismiss()
    }

    deleteButton.setOnClickListener {
        viewModel.deleteNote(note)
        confirmationDialog.dismiss()
        requireActivity().onBackPressed()
        requireActivity().onBackPressed()
    }

    confirmationDialog.setCancelable(true)
    confirmationDialog.setCanceledOnTouchOutside(true)
    confirmationDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
    confirmationDialog.window?.attributes?.dimAmount = 0.8f
    confirmationDialog.window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    confirmationDialog.setContentView(dialogView)
    confirmationDialog.show()
}

/********************************************************************************************************************************************/

<style name="DialogTheme" parent="Theme.AppCompat.Dialog">
    <item name="android:layout_marginStart">32dp</item>
    <item name="android:layout_marginEnd">32dp</item>
    <item name="android:windowIsFloating">true</item>
    <item name="android:windowMinWidthMajor">100%</item>
    <item name="android:windowMinWidthMinor">100%</item>
</style>

/********************************************************************************************************************************************/

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@drawable/background_2"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent">

    <TextView
        android:id="@+id/title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="32dp"
        android:layout_marginEnd="16dp"
        android:gravity="center"
        android:text="@string/are_you_sure"
        android:textColor="@color/purple_200"
        android:textSize="18sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/description"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:gravity="center"
        android:text="@string/delete_confirmation"
        android:textColor="@color/white"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/title" />

    <TextView
        android:id="@+id/delete_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:layout_marginBottom="32dp"
        android:background="@drawable/background_3"
        android:gravity="center"
        android:text="@string/delete"
        android:textColor="@color/white"
        android:textSize="16sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/cancel_button"
        app:layout_constraintTop_toBottomOf="@+id/description" />

    <TextView
        android:id="@+id/cancel_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:layout_marginBottom="32dp"
        android:background="@drawable/background_1"
        android:gravity="center"
        android:text="@string/cancel"
        android:textColor="@color/white"
        android:textSize="16sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/delete_button"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/description" />

</androidx.constraintlayout.widget.ConstraintLayout>