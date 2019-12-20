package timber.log

data class Event(
        val type: String,
        val params: HashMap<String, Any>? = null,
        val description: String? = null
) {

    override fun toString(): String {
        return "Type: ${this.type}, Description: ${this.description}, Params: ${this.params.toString()}"
    }
}
