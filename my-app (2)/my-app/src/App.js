import React, { useState } from 'react';
import PagPrincipal from './componentes/PagPrincipal';
import PagAdmin from './componentes/PagAdmin';
import PagUser from './componentes/PagUser';

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