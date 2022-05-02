package dev.nasonov.joy.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import app.softwork.bootstrapcompose.ToastContainer
import app.softwork.bootstrapcompose.ToastContainerState
import app.softwork.routingcompose.Router
import dev.nasonov.joy.model.State
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.AutoComplete.Companion.url
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.onSubmit
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.HTMLFormElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.url.URL

@Composable
fun AppHeader(){
    val toastContainerState: ToastContainerState = remember { ToastContainerState() }
    State.toastContainerState = toastContainerState
    ToastContainer(toastContainerState) {
        classes("position-absolute", "bottom-0", "end-0", "p-3")
        style {
            property("z-index", 1100)
        }
    }
    Nav (attrs = {
        classes("navbar", "navbar-expand-lg", "navbar-light", "bg-light")
    }){
        Div (attrs = {
            classes("container-fluid")
        }){
            A (attrs = {
                classes("navbar-brand")
            }, href = "#"){
                Text("Joy ⭐")

            }
            Button (attrs = {
                classes("navbar-toggler")
                attr("type","button")
                attr("data-bs-toggle","collapse")
                attr("data-bs-target","#navbarSupportedContent")
                attr("aria-controls","navbarSupportedContent")
                attr("aria-expanded","false")
                attr("aria-label","Toggle navigation")
            }){
                Span (attrs = {
                    classes("navbar-toggler-icon")
                }){}

            }
            Div (attrs = {
                classes("collapse", "navbar-collapse")
                id("navbarSupportedContent")
            }){
                Ul (attrs = {
                    classes("navbar-nav", "me-auto", "mb-2", "mb-lg-0")
                }){
//                    Li (attrs = {
//                        classes("nav-item")
//                    }){
//                        A (attrs = {
//                            classes("nav-link", "active")
//                            attr("aria-current","page")
//                        }, href = "#"){
//                            Text("Home")
//
//                        }
//
//                    }
                    Li (attrs = {
                        classes("nav-item")
                    }){
                        A (attrs = {
                            classes("nav-link")
                        }, href = "#/song/list"){
                            Text("Songs")

                        }

                    }
//                    Li (attrs = {
//                        classes("nav-item", "dropdown")
//                    }){
//                        A (attrs = {
//                            classes("nav-link", "dropdown-toggle")
//                            id("navbarDropdown")
//                            attr("role","button")
//                            attr("data-bs-toggle","dropdown")
//                            attr("aria-expanded","false")
//                        }, href = "#"){
//                            Text(" Dropdown ")
//
//                        }
//                        Ul (attrs = {
//                            classes("dropdown-menu")
//                            attr("aria-labelledby","navbarDropdown")
//                        }){
//                            Li {
//                                A (attrs = {
//                                    classes("dropdown-item")
//                                }, href = "#"){
//                                    Text("Action")
//
//                                }
//
//                            }
//                            Li {
//                                A (attrs = {
//                                    classes("dropdown-item")
//                                }, href = "#"){
//                                    Text("Another action")
//
//                                }
//
//                            }
//                            Li {
//                                Hr (attrs = {
//                                    classes("dropdown-divider")
//                                })
//
//                            }
//                            Li {
//                                A (attrs = {
//                                    classes("dropdown-item")
//                                }, href = "#"){
//                                    Text("Something else here")
//
//                                }
//
//                            }
//
//                        }
//
//                    }
//                    Li (attrs = {
//                        classes("nav-item")
//                    }){
//                        A (attrs = {
//                            classes("nav-link", "disabled")
//                            attr("tabindex","-1")
//                            attr("aria-disabled","true")
//                        }, href = "#"){
//                            Text("Disabled")
//
//                        }
//
//                    }

                }
                val router = Router.current
                Form (attrs = {
                    classes("d-flex")
                    onSubmit {
                        it.preventDefault()
//                        it.stopPropagation()
                        val k = it.target as HTMLFormElement
//                        println(k)
                        val input = k.querySelector("input") as HTMLInputElement
//                        println(input)
                        val search = input.value
//                        println(search)
                        val url = URL(window.location.toString());
                        url.hash = "/song/search"
                        url.searchParams.set("search", search);
//                        println("kek")
                        router.navigate("${url.hash}${url.search}")
//                        window.history.pushState(object {}, "", );

                    }
                }, action = "") {
                    Input(attrs = {
                        classes("form-control", "me-2")
                        attr("placeholder","Search")
                        attr("aria-label","Search")
                    }, type = InputType.Search)
                    Button (attrs = {
                        classes("btn", "btn-outline-success")
                        attr("type","submit")
                    }){
                        Text("Search")

                    }

                }

            }

        }

    }
}