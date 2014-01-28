package io.kuchat.client.view

import groovy.swing.SwingBuilder
import javax.swing.*
import java.awt.GridBagConstraints

class LoginFrame {

    static def loginViewFrame(){

        def swingBuilder = new SwingBuilder()

        def customMenuBar = {
            swingBuilder.menuBar{
                menu(text: "File", mnemonic: 'F') {
                    menuItem(text: "Exit", mnemonic: 'X', actionPerformed: { dispose() })
                }
            }
        }

        swingBuilder.edt{
            lookAndFeel 'nimbus'
            frame(title:"Ku Chat",
                defaultCloseOperation:JFrame.EXIT_ON_CLOSE,
                size:[400,500],
                show:true) {
                    customMenuBar()
                    panel(){
                        gridBagLayout()
                        tableLayout(constraints:gbc(gridwidth:GridBagConstraints.REMAINDER, fill:GridBagConstraints.HORIZONTAL)){
                            tr {
                                td {
                                    label 'Email:\t'
                                }
                                td {
                                    textField id: 'email', columns: 12
                                }
                            }
                            tr {
                                td {
                                    label 'Passwd:\t'
                                }
                                td {
                                    passwordField id: 'passwd', columns: 12
                                }
                            }
                        }
                        hbox(constraints:gbc(gridwidth:GridBagConstraints.REMAINDER, gridx:0,gridy:1)){
                            button text: "Login", actionPerformed: {
                                println ">_<"
                            }
                            button(text:"Cancel")
                        }
                    }
            }
        }
    }
}
