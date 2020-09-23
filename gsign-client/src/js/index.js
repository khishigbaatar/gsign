import React from 'react'
import { render } from 'react-dom'
import './dependency_styles.js'
import '../scss/index.scss'
import AppComponent from './AppComponent'

render((
    <AppComponent />
), document.getElementById('paypay'))
