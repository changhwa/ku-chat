package io.kuchat.client.auth.view

import groovy.swing.SwingBuilder
import io.kuchat.client.auth.controller.AuthController
import io.kuchat.client.auth.vo.AuthVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.swing.*
import java.awt.GridBagConstraints

@Component
class LoginFrame {

    @Autowired
    AuthController authController

    def loginViewFrame(){

        def swingBuilder = new SwingBuilder()

        def customMenuBar = {
            swingBuilder.menuBar{
                menu(text: "File", mnemonic: 'F') {
                    menuItem(text: "Exit", mnemonic: 'X', actionPerformed: { dispose() })
                }
            }
        }

        AuthVo authVo = new AuthVo()

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
                                authVo.email = email.text
                                authVo.passwd = passwd.text
                                authController.login(authVo)
                            }
                            button(text:"Cancel")
                        }
                    }
            }
        }
    }
}
