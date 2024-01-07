import BasicMenu from '../components/menus/BasicMenu';

const BasicLayout = ({ children }) => {
  return (
    <>
      {/* 기존 헤더 대신 BasicMenu*/}
      <BasicMenu />

      {/* 상단 여백 my-5 제거 */}
      <div className="layoutWarp">
        <main className="layoutMain">
          {' '}
          {/* 상단 여백 py-40 변경 flex 제거 */}
          {children}
        </main>
      </div>
    </>
  );
};

export default BasicLayout;
