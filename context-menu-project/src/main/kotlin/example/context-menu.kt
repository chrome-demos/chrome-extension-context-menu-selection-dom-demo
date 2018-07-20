package example

import chrome.contextMenus.CreateProperties
import kotlinjs.common.jsonAs
import kotlin.browser.window

fun main(args: Array<String>) {
    chrome.contextMenus.create(jsonAs<CreateProperties>().apply {
        title = "Alert selection HTML"
        contexts = arrayOf("selection")
        onclick = { _, tab ->
            chrome.tabs.sendMessage(tab.id!!, FETCH_SELECTION_HTML) { response ->
                window.alert(response.toString())
            }
        }
    })
}


