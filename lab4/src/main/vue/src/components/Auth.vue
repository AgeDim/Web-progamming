<template>
    <div id="content">
        <script type="application/javascript">
            $(document).ready(function () {
                $('.ui.large.form').form({
                    fields: {
                        username: {
                            identifier: 'username',
                            rules: [
                                {
                                    type: 'empty',
                                    prompt: 'Your username can\'t be empty'
                                },
                                {
                                    type: 'length[3]',
                                    prompt: 'Username must contain at least 3 characters'
                                }
                            ]
                        },
                        password: {
                            identifier: 'password',
                            rules: [
                                {
                                    type: 'empty',
                                    prompt: 'Your password can\'t be empty'
                                },
                                {
                                    type: 'length[5]',
                                    prompt: 'Password must contain at least 5 characters'
                                }
                            ]
                        }
                    },
                    onSuccess(e) {
                        e.preventDefault();
                    }
                });
            });
        </script>
        <div class="ui inverted vertical center aligned segment">
            <h2 class="ui header inverted grey">Агеев Дмитрий</h2>
        </div>
        <div class="ui middle aligned center aligned grid" style="margin-top: 89px;">
            <div class="column" style="width: 400px;">
                <div class="ui raised black segment">
                    <h2 class="ui header">Authentication</h2>
                    <form class="ui large form">
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="user icon"></i>
                                <input type="text" name="username" placeholder="Username" v-model.trim="username">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="lock icon"></i>
                                <input type="password" name="password" placeholder="Password" v-model.trim="password">
                            </div>
                        </div>
                        <div class="ui large buttons" style="justify-content: center;">
                            <button class="ui blue submit button" style="width: 168px" @click="login">
                                Login
                            </button>
                            <div class="or"></div>
                            <button class="ui green submit button" style="width: 168px"
                                    @click="register">
                                Register
                            </button>
                        </div>
                        <div class="ui error message"></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import $ from 'jquery';
import axios from 'axios';

export default {
    data() {
        return {
            username: '',
            password: ''
        }
    },
    created() {
        if (localStorage.getItem('jwt') != null) {
            this.$router.push('main');
        }
    },
    methods: {
        login(e) {
            this.sendRequest('login', this.$router, this.username, this.password, e);
        },
        register(e) {
            this.sendRequest('register', this.$router, this.username, this.password, e);
        },
        sendRequest(type, router, username, password, e) {
            setTimeout(async function () {
                e.target.classList.add('loading');
                if ($('.ui.large.form').hasClass('success')) {
                    await axios.post('/api/auth/' + type, {
                        username,
                        password
                    }).then(response => {
                        localStorage.setItem("jwt", response.data);
                        router.push('main');
                    }).catch(error => {
                        let msg_parts = error.response.data.split(':');
                        if (msg_parts[0] === '0') {
                            document.querySelectorAll('.field')[0].classList.add('error');
                        } else {
                            document.querySelectorAll('.field')[1].classList.add('error');
                        }
                        let err_msg = $('.error.message');
                        err_msg.html('<ul class="list"><li>' + msg_parts[1] + '</li></ul>');
                        err_msg.css('display', 'block');
                    });
                }
                e.target.classList.remove('loading');
            }, 1);
        }
    }
}
</script>