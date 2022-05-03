package dev.nasonov.joy.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import app.softwork.bootstrapcompose.*
import app.softwork.routingcompose.Router
import dev.nasonov.joy.components.utils.unaryPlus
import dev.nasonov.joy.model.State
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.uuid.UUID
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
fun AppHeader(search: String? = null){
    val toastContainerState: ToastContainerState = remember { ToastContainerState() }
    State.toastContainerState = toastContainerState
    ToastContainer(toastContainerState) {
        classes("position-absolute", "bottom-0", "end-0", "p-3")
        style {
            property("z-index", 1100)
        }
    }
    Navbar(
//        brand = {
//
//        },

        colorScheme = Color.Light,
        backgroundColor = Color.Light,
//        toggler = true,
//        togglerPosition = TogglerPosition.Right,
        collapseBehavior = NavbarCollapseBehavior.AtBreakpoint(Breakpoint.Medium),
        containerBreakpoint = Breakpoint.Medium,
        content = {
            Brand {
                +"Joy ⭐"
            }
            val togglerTargetId = "toggler${UUID()}"

            Toggler(
                target = togglerTargetId,
                controls = togglerTargetId
            )
            NavbarCollapse(togglerTargetId) {
                NavbarNav(attrs = { classes("me-auto") }) {
                    NavbarLink(
                        active = false,
                        link = "#/song/list"
                    ) {
                        +"Songs"
                    }
                }
                SearchForm(search)
            }
        })
//    }
//    Nav (attrs = {
//        classes("navbar", "navbar-expand-lg", "navbar-light", "bg-light")
//    }){
//        Div (attrs = {
//            classes("container-fluid")
//        }){
//            A (attrs = {
//                classes("navbar-brand")
//            }, href = "#"){
//                +"Joy ⭐"
//
//            }
//            Button (attrs = {
//                classes("navbar-toggler")
//                attr("type","button")
//                attr("data-bs-toggle","collapse")
//                attr("data-bs-target","#navbarSupportedContent")
//                attr("aria-controls","navbarSupportedContent")
//                attr("aria-expanded","false")
//                attr("aria-label","Toggle navigation")
//            }){
//                Span (attrs = {
//                    classes("navbar-toggler-icon")
//                }){}
//
//            }
//            Div (attrs = {
//                classes("collapse", "navbar-collapse")
//                id("navbarSupportedContent")
//            }){
//                Ul (attrs = {
//                    classes("navbar-nav", "me-auto", "mb-2", "mb-lg-0")
//                }){
//                    Li (attrs = {
//                        classes("nav-item")
//                    }){
//                        A (attrs = {
//                            classes("nav-link")
//                        }, href = "#/song/list"){
//                            Text("Songs")
//
//                        }
//
//                    }
//
//                }
//
//
//            }
//
//        }
//
//    }
}