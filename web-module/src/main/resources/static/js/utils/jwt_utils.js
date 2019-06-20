function storeJwt(jwt) {
    localStorage.setItem('jwt', jwt);
}

function getJwt() {
    if (localStorage.hasOwnProperty('jwt')) {
        let jwtStr = localStorage.getItem('jwt');
        return jwtStr;
    }
    if (sessionStorage.hasOwnProperty('jwt')) {
        let jwtStr = sessionStorage.getItem('jwt');
        return jwtStr;
    }
    return null;
}

function storeUser(user) {
    let userStr = JSON.stringify(user);
    sessionStorage.setItem('user', userStr);
}

function getUser() {
    if (sessionStorage.hasOwnProperty('user')) {
        let jwtStr = sessionStorage.getItem('user');
        return JSON.parse(jwtStr);
    }
    return null;
}