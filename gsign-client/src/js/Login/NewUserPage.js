import React from 'react'

export default class NewUserPage extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            displayErrorMessageFlag: false
        }

        this.handleSubmitEvent = this.handleSubmitEvent.bind(this)
    }

    handleSubmitEvent(event) {
        event.preventDefault();

        let username = this.refs.usernameInput.value;
        let password = this.refs.passwordInput.value;
        fetch('http://localhost:8080/employers/create', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: "username=" + username+ "&password=" + password
        })
                .then(res => res.json())
                .then((data) => {
                    this.setState({displayErrorMessageFlag:true})
                })

    }

    render() {
        return (
            <form onSubmit={this.handleSubmitEvent} id='login-form'>
                アカウント新規登録画面
                <div className='username'>
                    <label>ログインID
                        <input ref='usernameInput' id='username-input'/>
                    </label>
                </div>
                <div className='password'>
                    <label>パスワード
                        <input ref='passwordInput' type='password' id='password-input'/>
                    </label>
                </div>
                <button className='create small' type='submit'>
                    登録
                </button>
            </form>
        )
    }
}
