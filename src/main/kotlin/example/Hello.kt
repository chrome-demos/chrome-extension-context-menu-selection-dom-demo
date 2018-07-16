package example

import JsObj
import chrome.tabs.QueryInfo
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    document.addEventListener("DOMContentLoaded", {
        getCurrentTabUrl { url ->
            window.alert("current url is: $url")
        }
    })
}

private fun getCurrentTabUrl(callback: (String) -> Unit) {
    val queryInfo = JsObj<QueryInfo>().apply {
        active = true
        currentWindow = true
    }
    chrome.tabs.query(queryInfo) { tabs ->
        tabs.firstOrNull()?.url?.run(callback)
    }
}

