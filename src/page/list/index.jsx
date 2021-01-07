/* index.jsx */
import myStyles from './styles.css'
const lang = window.navigator.language;
export default () => {
  const helloworld = lang === 'en-US' ? 'hello world' : '你好';
    return (
      <div className={myStyles.hello}>{helloworld}</div>
 
    );
  };