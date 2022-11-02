package hasan.gurgur.enerjisatask.model

data class ItemModel(
    val errorCode: Any,
    val errorMessage: Any,
    val isMaintenance: Boolean,
    val logUrl: String,
    val requestId: String,
    val result: Result,
    val sid: String,
    val statusCode: Int,
    val validationErrorMessages: Any
)