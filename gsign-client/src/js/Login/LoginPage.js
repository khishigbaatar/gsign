import React from 'react'

export default class LoginPage extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            displayErrorMessageFlag: false
        }

        this.handleSubmitEvent = this.handleSubmitEvent.bind(this)
        this.addNewUserButtonWasClicked = this.addNewUserButtonWasClicked.bind(this)
    }

    addNewUserButtonWasClicked(event) {
        this.props.history.push('/new/' + this.state.username + '/'+ this.state.username )
    }

    handleSubmitEvent(event) {
        event.preventDefault();

        let username = this.refs.usernameInput.value;
        let password = this.refs.passwordInput.value;
        fetch('http://localhost:8080/employers', {
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

    showErrorMessage() {
        if (this.state.displayErrorMessageFlag) {
            return (
                <div className='error-message'>error</div>
            )
        }
    }

    render() {
        return (
            <form onSubmit={this.handleSubmitEvent} id='login-form'>
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
                {this.showErrorMessage()}
                <button className='sign-in small' type='submit'>
                    ログイン
                </button>
                <button className='new-account small' onClick={this.addNewUserButtonWasClicked}>
                    新規登録
                </button>
            </form>
        )
    }
}
