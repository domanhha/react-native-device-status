import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import { isDeviceSecure } from 'react-native-device-status';

export default function App() {
  const [result, setResult] = React.useState<string | undefined>();

  React.useEffect(() => {
    isDeviceSecure().then((res) => {
      setResult(res ? "Yes" : "No" )
    });
  }, []);

  return (
    <View style={styles.container}>
      <Text style={styles.text}>Device Security: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: "#fff"
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
  text: {
    color: "#000"
  }
});
