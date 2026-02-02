import {Profile} from "../model/Profile"

export const useRegister = () => {
    const [error, setError] = useState<string>("");
    const [isLoading, setLoader] = useState<boolean>(false);
    const [toast, setToast] = useState<string>("");
    const signup = (profile: Profile) => {
        setLoader(true);
      createProfile(profile)
        .then((response) => {
          if (response && response.status === 201) {
            setToast("Profile is successfully created");
          }
        })
        .catch((error) => console.log(error.message ))
        .finally(() => setLoader(false));
    
    }
}