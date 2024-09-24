// File: src/componentes/PagUser.js
import React from 'react';

function PagUser({ onLogout }) {
    return (
        <div>
            <h1>User Screen</h1>
            <button onClick={onLogout}>Logout</button>
        </div>
    );
}

export default PagUser;