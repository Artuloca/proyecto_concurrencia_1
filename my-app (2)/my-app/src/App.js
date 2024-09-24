import React, { useState } from 'react';
import LoginScreen from './components/LoginScreen';
import AdminScreen from './components/AdminScreen';
import UserScreen from './components/UserScreen';

function App() {
    const [user, setUser] = useState(null);

    const handleLogin = (user) => {
        setUser(user);
    };

    if (!user) {
        return <PagPrincipal onLogin={handleLogin} />;
    }

    if (user.esAdmin) {
        return <PagAdmin />;
    }

    return <PagUser />;
}

export default App;