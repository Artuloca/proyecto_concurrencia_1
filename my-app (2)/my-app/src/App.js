import React, { useState, useEffect } from 'react';
import PagPrincipal from './componentes/PagPrincipal';
import PagAdmin from './componentes/PagAdmin';
import PagUser from './componentes/PagUser';

function App() {
    const [user, setUser] = useState(null);

    const handleLogin = (user) => {
        setUser(user);
    };

    const handleLogout = () => {
        setUser(null);
    };

    useEffect(() => {
        // Aquí puedes agregar cualquier lógica adicional que necesites para manejar la concurrencia
    }, [user]);

    if (!user) {
        return <PagPrincipal onLogin={handleLogin} />;
    }

    if (user.esAdmin) {
        return <PagAdmin onLogout={handleLogout} />;
    }

    return <PagUser onLogout={handleLogout} />;
}

export default App;