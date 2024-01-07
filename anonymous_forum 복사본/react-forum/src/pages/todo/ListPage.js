import ListComponent from '../../components/todo/ListComponent';
import styles from './Page.module.css';

const ListPage = () => {
  return (
    <div className={styles.PageContainer}>
      <div className={styles.PageWapr}>
        <div className={styles.PageContent}>LIST</div>
      </div>
      <ListComponent />
    </div>
  );
};

export default ListPage;
