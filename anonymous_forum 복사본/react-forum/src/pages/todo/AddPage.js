import AddComponent from '../../components/todo/AddComponent';
import styles from './Page.module.css';
const AddPage = () => {
  return (
    <div className={styles.PageContainer}>
      <div className={styles.PageWapr}>
        <div className={styles.PageContent}>ADD</div>
      </div>
      <AddComponent />
    </div>
  );
};

export default AddPage;
