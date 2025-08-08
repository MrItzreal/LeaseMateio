import {
  SignedIn,
  SignedOut,
  SignInButton,
  UserButton,
  useAuth,
} from "@clerk/clerk-react";

const App = () => {
  const { getToken } = useAuth();

  const handleGetToken = async () => {
    const token = await getToken();
    console.log("Your JWT is:", token);
    alert("Token has been printed to the console! (Press F12)");
  };

  return (
    <header>
      <h3>LeaseMateIO</h3>
      <SignedOut>
        <SignInButton />
      </SignedOut>
      <SignedIn>
        <div>
          <button onClick={handleGetToken}>Get My Token</button>
          <UserButton
            appearance={{
              elements: {
                userButtonAvatarBox: {
                  width: "3rem",
                  height: "3rem",
                },
              },
            }}
          />
        </div>
      </SignedIn>
    </header>
  );
};

export default App;
