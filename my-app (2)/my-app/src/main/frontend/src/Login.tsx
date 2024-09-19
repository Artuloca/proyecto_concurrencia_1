import React, { useState, ChangeEvent } from 'react';

const Login: React.FC = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [showNewPopup, setShowNewPopup] = useState(false);

    const handleLogin = () => {
        // Aquí puedes manejar la lógica de inicio de sesión
        console.log('Username:', username);
        console.log('Password:', password);
        setShowNewPopup(true);
    };

    const handleUsernameChange = (e: ChangeEvent<HTMLInputElement>) => {
        setUsername(e.target.value);
    };

    const handlePasswordChange = (e: ChangeEvent<HTMLInputElement>) => {
        setPassword(e.target.value);
    };

    return (
        <div>
            {!showNewPopup ? (
                <div style={styles.overlay}>
                    <div style={styles.popup}>
                        <h2>Login</h2>
                        <input
                            type="text"
                            placeholder="Username"
                            value={username}
                            onChange={handleUsernameChange}
                            style={styles.input}
                        />
                        <input
                            type="password"
                            placeholder="Password"
                            value={password}
                            onChange={handlePasswordChange}
                            style={styles.input}
                        />
                        <button onClick={handleLogin} style={styles.button}>Login</button>
                    </div>
                </div>
            ) : (
                <div style={styles.overlay}>
                    <div style={styles.popup}>
                        {/* Nuevo pop-up vacío */}
                    </div>
                </div>
            )}
        </div>
    );
};

const styles = {
    overlay: {
        position: 'fixed' as 'fixed',
        top: 0,
        left: 0,
        right: 0,
        bottom: 0,
        backgroundColor: 'rgba(0, 0, 0, 0.5)',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
    },
    popup: {
        backgroundColor: 'white',
        padding: '20px',
        borderRadius: '5px',
        boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
    },
    input: {
        display: 'block',
        width: '100%',
        padding: '10px',
        margin: '10px 0',
        borderRadius: '5px',
        border: '1px solid #ccc',
    },
    button: {
        padding: '10px 20px',
        borderRadius: '5px',
        border: 'none',
        backgroundColor: 'black',
        color: 'white',
        cursor: 'pointer',
    },
};

export default Login;